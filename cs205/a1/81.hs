import Test.QuickCheck
import Prelude
import Data.Char

-- Question 1
-- a)
max1 :: (Ord a, Num a) => a -> a -> a -> a
max1 a b c
    | a > b && a > c = a
    | b > c = b
    | otherwise = c

max2 :: (Ord a, Num a) => a -> a -> a -> a
max2 a b c = max2' (a:(b:(c:[]))) a

max2' :: (Ord a, Num a) => [a] -> a -> a
max2' [] max = max
max2' (x : xs) max
    | x > max = max2' xs x
    | otherwise = max2' xs max

-- b)
checkcorrectness :: (Ord a, Num a) => a -> a -> a -> Bool
checkcorrectness x y z = max1 x y z == max2 x y z

{- 
*Main> :l 81
[1 of 1] Compiling Main             ( 81.hs, interpreted )
Ok, one module loaded.
*Main> quickCheck checkcorrectness
+++ OK, passed 100 tests.
-}

-- This test checks if the output of both functions are identical, however if both functions are 
-- incorrect in the same way they will still produce an identicle output, thus passing the tests.
-- Even though the result of the functions is logically incoreect the tests still pass.
-- This could be improved by also passing the known correct answer into the tests to comapre the ouput of the functions against.

-- Question 2

luigi :: Float -> Float -> Float
luigi toppings diameter = roundPrice ((calculateBase + calculateToppings) * 1.6)
    where 
        calculateBase = (pi * ((diameter/2)^2)) * 0.002
        calculateToppings = toppings * 0.6

roundPrice :: Float -> Float
roundPrice price = (fromIntegral (floor (price * t))) / t
    where t = 10^2

{-
*Main> :l 81     
[1 of 1] Compiling Main             ( 81.hs, interpreted )-
Ok, one module loaded.
*Main> luigi 6 15
6.32
*Main> luigi 2 32
4.49

Pizza Bambini = £6.32
Pizza Famiglia = £4.49

Yes, Pizza Bambini is more expensive than Pizza Famiglia.
-}


-- Question 3
-- a)
digitCountListComprehension :: String -> Int
digitCountListComprehension input = length [x | x <- input, isDigit x]

-- b)
digitCountHigherOrder :: ((Char -> Bool) -> [Char] -> [Char]) -> String -> Int
digitCountHigherOrder _ [] = 0
digitCountHigherOrder function input = length (function (isDigit) input)

-- c)
digitCountRecursive :: String -> Int
digitCountRecursive input = digitCountRecursive' input 0 

digitCountRecursive' :: [Char] -> Int -> Int
digitCountRecursive' [] acc = acc
digitCountRecursive' (x : xs) acc
    | isDigit x = digitCountRecursive' xs (acc + 1)
    | otherwise = digitCountRecursive' xs acc

-- Answers

counta, countb, countc :: Int
counta = digitCountListComprehension "a1b2c3d4e5"
countb = digitCountHigherOrder (filter) "a1b2c3d4e5"
countc = digitCountRecursive "a1b2c3d4e5"

-- Question 5--
-- a)
won :: [Int] -> Bool
won (x:xs)
    | x /= 0 = False
    | xs == [] && x /= 0 = False
    | xs == [] && x == 0 = True
    | otherwise = won xs

-- b)
validMove :: [Int] -> Int -> Int -> Bool
validMove (x:xs) pileNo remove
    | pileNo > length (x:xs) = False
    | pileNo == 0 = False
    | remove == 0 = False
    | pileNo == 1 && x - remove < 0 = False
    | pileNo == 1 && x - remove >= 0 = True
    | otherwise = validMove xs (pileNo - 1) remove

-- c)
takeAway :: [Int] -> Int -> Int -> [Int]
takeAway list pileNo remove = takeAway' list [] pileNo remove

takeAway' :: [Int] -> [Int] -> Int -> Int -> [Int]
takeAway' (x:xs) newList pileNo remove
    | xs == [] && pileNo /= 1 = newList ++ ([x])
    | xs == [] && pileNo == 1 = newList ++ ([x - remove])
    | pileNo == 1 = takeAway' xs (newList ++ ([x - remove])) (pileNo - 1) remove
    | otherwise = takeAway' xs (newList ++ [x]) (pileNo - 1) remove

-- d)
getMove1 :: [Int] -> IO(Int,Int)
getMove1 list = do 
    putStr "Enter which pile to remove from and then amount to remove: \n"
    x <- readLn
    y <- readLn
    return (x,y)
            
-- e)
getMove2 :: [Int] -> IO(Int,Int)
getMove2 list = do 
    putStr "Enter which pile to remove from and then amount to remove: \n"
    x <- readLn
    y <- readLn
    if validMove list x y
        then return (x,y)
    else getMove2 list

-- f)
displayGame :: [Int] -> IO()
displayGame list = displayGame' list 1
    
displayGame' :: [Int] -> Int -> IO()
displayGame' (x:xs) y =
    if not(xs == []) then do 
        putStr ((show y) ++ ": ")
        displayLine x
        displayGame' xs (y + 1)
    else do 
        putStr ((show y) ++ ": ")
        displayLine x

displayLine :: Int -> IO()
displayLine x =
    if x > 1 then do 
        putStr "*"
        displayLine (x - 1)
    else if x == 0 then do putStr "\n"
        else putStr "*\n"  

-- g)
nim :: IO()
nim = do 
         putStr "Enter player 1 name:\n"
         p1 <- getLine
         putStr "Enter player 2 name:\n"
         p2 <- getLine
         putStr "Enter a list of piles for the initial configuration of the piles.\n"
         input <- getLine
         let list = read input :: [Int]
         if list == [] then 
            nimaux [5,4,3,6] p1 p2
            else nimaux list p1 p2


nimaux :: [Int] -> String -> String -> IO()
nimaux list p1 p2 = do 
                    putStr (p1 ++ "'s turn \n")
                    displayGame list 
                    p1Move <- getMove2 list
                    let newList = takeAway list (fst p1Move) (snd p1Move)
                    if won newList then do 
                                        putStr (p1 ++ " wins!\n")
                    else do 
                            putStr (p2 ++ "'s turn \n")
                            displayGame newList 
                            p2Move <- getMove2 newList
                            let newList2 = takeAway newList (fst p2Move) (snd p2Move)
                            if won newList2 then do
                                                putStr (p2 ++ " wins!\n")
                            else nimaux newList2 p1 p2 

-- h)
{-
*Main> :l 81     
[1 of 1] Compiling Main             ( 81.hs, interpreted )
Ok, one module loaded.
*Main> nim
Enter player 1 name:
fraser
Enter player 2 name:
toby
Enter a list of piles for the initial configuration of the piles.
[4,7,4,2,8]
fraser's turn 
1: ****
2: *******
3: ****
4: **
5: ********
Enter which pile to remove from and then amount to remove: 
1
4
toby's turn 
1:
2: *******
3: ****
4: **
5: ********
-}

-- Question 6
--a)
stratB :: [Int] -> (Int,Int)
stratB list = stratB' list 1

stratB' :: [Int] -> Int -> (Int,Int)
stratB' (x:xs) acc
    | x > 0 = (acc,x)
    | otherwise = stratB' xs (acc + 1)

-- b) 
nimAI :: ([Int] -> (Int, Int)) -> IO()
nimAI strat = do 
              putStr "Enter you name:\n"
              p1 <- getLine
              putStr "\nEnter a list of piles for the initial configuration of the piles.\n"
              input <- getLine
              let list = read input :: [Int]
              if list == [] then 
                    nimAIaux [5,4,3,6] strat p1
              else nimAIaux list strat p1

nimAIaux :: [Int] -> ([Int] -> (Int, Int)) -> String -> IO()
nimAIaux list strat p1 = do 
                        putStr (p1 ++ "'s turn \n")
                        displayGame list 
                        p1Move <- getMove2 list
                        let newList = takeAway list (fst p1Move) (snd p1Move)
                        if won newList then do 
                                            putStr (p1 ++ " wins!\n")
                                            else do 
                                                putStr ("AI's turn\n")
                                                displayGame newList
                                                let newList2 = takeAway newList (fst (strat newList)) (snd (strat newList))
                                                if won newList2 then do
                                                                    putStr ("AI wins!\n")
                                                else nimAIaux newList2 strat p1
           
-- c)
-- The AI in this section will remove all but one coin from the first non zero pile if there are two piles left.
-- If there is one pile left with coins in it will take all of the coins in the last non-zero pile.
-- Otherwise it will take all coins from the first none empty pile.

stratI :: [Int] -> (Int, Int)
stratI list = stratI' list 1 

check1Pile :: [Int] -> Int -> Bool
check1Pile [] acc = acc == 1
check1Pile (x:xs) acc
    |x > 0 = check1Pile xs (acc + 1)
    | otherwise = check1Pile xs acc

check2Pile :: [Int] -> Int -> Bool
check2Pile [] acc = acc == 2
check2Pile (x:xs) acc
    | x > 0 = check2Pile xs (acc + 1)
    | otherwise = check2Pile xs acc

stratI' :: [Int] -> Int -> (Int,Int)
stratI'  (x:xs) acc = if (check1Pile (x:xs) 0) && x > 0 then
    (acc, x)
    else if (check2Pile (x:xs) 0) && x > 2 then
        (acc, x - 1)
        else if x > 0 then
            (acc, x)
            else stratI' xs (acc + 1)

{-
*Main> :l 81     
[1 of 1] Compiling Main             ( 81.hs, interpreted )
Ok, one module loaded.
*Main> nimAI stratI
Enter you name:
fraser

Enter a list of piles for the initial configuration of the piles.
[4,6,2,7]
fraser's turn 
1: ****
2: ******
3: **
4: *******
Enter which pile to remove from and then amount to remove: 
3
2
AI's turn
1: ****
2: ******
3:
4: *******
fraser's turn
1:
2: ******
3: 
4: *******
Enter which pile to remove from and then amount to remove:
4
2
AI's turn
1:
2: ******
3:
4: *****
fraser's turn
1:
2: *
3:
4: *****
Enter which pile to remove from and then amount to remove: 
2
1
AI's turn
1:
2:
3:
4: *****
AI wins!
-}