equalList :: [Char] -> [Char] -> Bool
equalList x y = x == y

equalListIndex :: [Char] -> [Char] -> Int -> Bool
equalListIndex x y z = x!!z == y!!z

swap (x,y) = (y,x)
middle (x,y,z) = y

palinedrome :: Eq [Char] => [Char] -> Bool 
palinedrome xs = xs == reverse xs

multTwo :: Int -