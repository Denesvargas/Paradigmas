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