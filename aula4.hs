--- exercicio 1

geraTabela :: Int -> [(Int,Int)]
geraTabela 0 = []
geraTabela x = (x,x*x):(geraTabela (x - 1))

--- exercicio 2

contido :: Char -> String -> Bool
contido _ [] = False
contido c (x:xs)
  | (x == c) = True
  | otherwise = contido c xs

--- exercicio 3

translate :: [(Float,Float)]->[(Float,Float)]
translate [] = []
translate lis = (somaDois (head lis)):(translate (tail(lis)))

somaDois :: (Float,Float)->(Float,Float)
somaDois (x,y) = (x+2,y+2)

--- exercicio 4

geraTabela' :: Int -> [(Int,Int)]
geraTabela' x = inverte (geraTabela x)

inverte :: [(Int,Int)] -> [(Int,Int)]
inverte [] = []
inverte (x:xs) = (inverte xs) ++ [x]
