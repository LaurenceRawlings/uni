module Q4 where

normaliseSpace::String -> String
normaliseSpace input = normaliseSpace' input "" 0

normaliseSpace' :: String -> String -> Int -> String
normaliseSpace' [] return _ = return
normaliseSpace' (x:xs) return spaces
        | spaces == 0 && x == ' ' = normaliseSpace' xs (return ++ [x]) (spaces + 1)
        | spaces > 0  && x == ' ' = normaliseSpace' xs return (spaces + 1)
        | otherwise = normaliseSpace' xs (return ++ [x]) 0

normaliseFront::String -> String
normaliseFront input = normaliseFront' input 

normaliseFront' :: String -> String
normaliseFront' [] = ""
normaliseFront' (x:xs) 
    | x == ' ' = normaliseFront' xs
    | otherwise = (x:xs)

normaliseBack::String -> String
normaliseBack input = reverse (normaliseFront (reverse input))

normalise::String -> String
normalise input = normaliseBack (normaliseFront (normaliseSpace input))

prefix::String -> String -> Bool
prefix [] _ = True
prefix _ [] = False
prefix xs ys
    | take (length xs) ys == xs = True
    | otherwise = False

substr::String -> String -> Bool
substr (_:_) [] = False
substr xs ys
    | prefix xs ys = True
    | substr xs (tail ys) = True
    | otherwise = False

postfix::String -> String -> Bool
postfix xs ys = prefix (reverse xs) (reverse ys)

substitute::String -> String -> String -> String
substitute key replaceValue input = substitute' key replaceValue input ""

substitute' :: String -> String -> String -> String -> String
substitute' [] _ current _ = current
substitute' _ _ [] return = return
substitute' key replaceValue (x:xs) return
    | prefix key (x:xs) = substitute' key replaceValue (drop (length key) (x:xs)) (return ++ replaceValue)
    | otherwise = substitute' key replaceValue xs (return ++ [x])

