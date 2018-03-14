--- exercicio 1

isVowel :: Char -> Bool
isVowel x 
 | x == 'a' = True
 | x == 'e' = True
 | x == 'i' = True
 | x == 'o' = True
 | x == 'u' = True
 |otherwise = False
 
isVogal :: Char -> Bool
isVogal x = elem x "aAeEiIoOuU"

--- exercicio 2

addComma :: [String] -> [String]
addComma strs = map ( ++ ",") strs

--- exercicio 3
htmiliza :: String -> String
htmiliza str = "<LI>" ++ str ++ "</LI>"

htmlListItems :: [String] -> [String]
htmlListItems x = map (htmiliza) x

htmlListItemsAnoNima :: [String] -> [String]
htmlListItemsAnoNima x = map (\n-> ("<LI>" ++ n ++ "</LI>")) x

--- exercicio 4
tiraVogal :: String -> String
tiraVogal str = filter (\n-> not(n `elem` "aAeEiIoOuU")) str

nao :: Char -> Bool
nao x = not(isVogal x)

semVogais :: String -> String 
semVogais x = filter (nao) x

--- exercicio 5
traco :: Char -> Char
traco x
  |x == ' ' = ' '
  |otherwise = '-'

codifica :: String -> String 
codifica str = map (traco) str

codiNonima :: String -> String
codiNonima str = map (\n-> if n /= ' ' then '-' else ' ') str

--- exercicio 6

firstName :: String -> String
firstName x = takeWhile (/= ' ') x

--- exercicio 7
isInt :: String -> Bool
isInt x = length(filter(\n-> not(elem n "1234567890")) x)  <= 0

--- exercicio 8 
lastName :: String -> String 
lastName str = last (words str)


