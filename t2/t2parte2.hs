import Data.Char

--- exercicio 1

soBin :: String -> Bool
soBin [] = True
soBin (x:xs)
  | x /= '0' && x /= '1' = False
  | otherwise = soBin xs
  
isBin :: String -> Bool
isBin x 
  | (length x) == 0 = False
  | (head x) /= '1' && (head x) /= '0' = False
  | otherwise = soBin (tail x)

--- exercicio 2

isBin' :: String -> Bool
isBin' str = not(any (\x -> x /= '0' && x /= '1') str) && length str /= 0

-- exercicio 3
bin2dec :: [Int] -> Int
bin2dec [] = undefined
bin2dec bits = auxBin2Dec bits ((length bits)-1)

auxBin2Dec :: [Int] -> Int -> Int
auxBin2Dec [] _ = 0
auxBin2Dec (x:xs) y = x*(2^(y)) + auxBin2Dec xs (y-1)

--- exercicio 4
bin2dec' :: [Int] -> Int
bin2dec' [] = undefined
bin2dec' bits = sum (zipWith (\x y-> x*(2^y)) bits [(length bits - 1), (length bits - 2)..])

--- exercicio 5
dec2bin :: Int -> [Int]
dec2bin 0 = []
dec2bin x = reverse (aux x)

aux :: Int -> [Int]
aux x = (x `mod` 2):(dec2bin (x `div` 2))

--- exercicio 6

dec2hex :: Int -> String
dec2hex x = toString (reverse (aux2 x))

toString :: [Int] -> String
toString [] = []
toString (x:xs) = (intToDigit x):(toString xs) 

aux2 :: Int -> [Int]
aux2 0 = []
aux2 x = (x `mod` 16):(aux2 (x `div` 16))
