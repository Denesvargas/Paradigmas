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

Questão 11.
Para que Eduardo tenha a maior vantagem possível sobre Maria, ou seja, para que ele ganhe uma quantidade de doces que seja maior
do que a de Maria pela maior diferença possível, qual deve ser o valor de x sorteado, entre os valores abaixo?
(A)32
(B)9
(C)51
(D)17
(E)20
-}

divideDoces :: Int -> Bool
divideDoces 1 = True
divideDoces x 
  | x `mod` 2 == 0 = divideDoces (div x 2)
  | otherwise = False 

{- Para Quaisquer valores basta verificar qual o maior numero das opçôes dadas na questão que satisfaça a função divideDoces
nesse caso a resposta correta é a letra A.
-}
