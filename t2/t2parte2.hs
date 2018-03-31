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
