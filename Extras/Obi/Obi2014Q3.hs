{-Link da Obi 2014: https://olimpiada.ic.unicamp.br/static/extras/obi2014/provas/ProvaOBI2014_f1i1.pdf
Modalidade iniciação, nivel 1. 

Questão 3. Um palíndrome é um número inteiro positivo, sem zeros à esquerda, que é o mesmo se
lido da esquerda para a direita ou da direita para a esquerda. Por exemplo, os números 11 e 65256
são palíndromes, mas os números 010 e 123 não são. A diferença entre o valor do maior palíndrome
de três dígitos e o menor palíndrome de três dígitos é:
(A) 989
(B) 888
(C) 898
(D) 998
(E) 979
-}

questao3 :: Int -> Int
questao3 n = ((10^n)-1) - ((10^(n-1))+1)

{-A questão3 tem como entrada os N digitos para a diferença do maior palíndrome e o menor palíndrome de N digitos.
nesse caso ao colocar a entrada '3' o valor será de 898, ou seja, resposta C é a correta.
-}
