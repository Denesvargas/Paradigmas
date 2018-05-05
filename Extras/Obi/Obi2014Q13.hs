
{- Link da Prova da Obi 2014: https://olimpiada.ic.unicamp.br/static/extras/obi2014/provas/ProvaOBI2014_f1i1.pdf
Modalidade iniciação nivel 1, fase 1.

->Jogo de Doces
Maria e Eduardo ganharam vários doces, e decidem jogar um jogo para decidir a quantidade de doces
que cada um terá direito. O jogo funciona da seguinte maneira:
1.  Inicialmente, um número inteiro positivo x é sorteado em uma roleta;
2.  Enquanto x for maior do que zero, repete-se o procedimento:
• Se x for par, Eduardo pega um doce e divide x por dois;
• Caso contrário, Maria pega um doce e subtrai 1 de x;
• Volta-se ao passo 2 com o novo valor de x;

Questão 13.
Suponha  que  Maria,  para  ganhar mais  doces, pudesse  mudar  exatamente  uma parte  da  regra: 
o  número  que  ela  subtrai  de xao pegar um doce para si. Para ganhar a maior quantidade  de  doces  possível,
qual  deveria  ser sua escolha?
(A)1
(B)2
(C)3
(D)4
(E)Nenhuma das anteriores
-}

somadoces2 :: Int -> Int -> Int -> Int -> (Int,Int)
somadoces2 0 x y _ = (x,y)
somadoces2 d x y n
  | d < 0 = somadoces2 0 x y n
  | d `mod` 2 == 0 = somadoces2 (div d 2) (x+1) (y) n
  | otherwise = somadoces2 (d-n) (x) (y+1) n
  
{- A função somadoces2 tem como entrada 4 elementos, o numero de doces sorteados(D), numero inicial de balas de Eduardo(X),
Numero inicial de balas de Maria(Y), numero de balas removidas quando maria pega uma bala(N), sucessivamente nessa ordem. Quando 
colocamos um valor de doces sorteados e mudamos o N, o numero Y pode sofrer alterações dependendo do numero N. A saída
de cada um dos testes gera uma tupla sendo (X,Y).  
Ex:
> somadoces2 100 0 0 1
> somadoces2 100 0 0 2
> somadoces2 100 0 0 3
> somadoces2 100 0 0 4

de todos os testes nota-se que o valor 2 gera mais doces para maria(Y). pois ao cair em um numero impar o proximo
numero será impar em qualquer caso de D diferente de 1 ou 0. Resposta correta letra B.
-}
