import org.multiverse.api.StmUtils;
import org.multiverse.api.references.TxnRef;

import java.util.Date;

public class UsbDrive extends HardDrive {
    private TxnRef lastUpdate;

    private void updateDate () {
        lastUpdate = StmUtils.newTxnRef(new Date());
    }

    /*
    * This is a simple method that reads from a UsbDrive
    * object, and then copies the contents from a given
    * address to the other UsbDrive object at a given
    * address. It finally erases the origin.
    * @param other The destination instance of UsbDrive.
    * @param originAddress The address of the data in this instance of UsbDrive.
    * @param destAddress The address of the data in destination.
    */
    private synchronized void cutAndPaste(UsbDrive other, int originAddress, int destAddress) {
        // read, write and erase methods are defined in super class CS-210: Page 2 of 8
        // they do not have any mechanism to ensure atomicity
        byte[] data = read(originAddress);
        boolean success = other.write(data, destAddress);
        if (success) {
            erase(originAddress);
            updateDate();
        }
        else {
            throw new java.lang.RuntimeException("Write failed!");
        }
    }

    public void atomicCutAndPaste (UsbDrive other, int originAddress, int destAddress) {
        StmUtils.atomic(() -> cutAndPaste(other, originAddress, destAddress));
    }
}
