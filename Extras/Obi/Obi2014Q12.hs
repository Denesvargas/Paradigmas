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

Questão 12.
Para  que  a  maior  quantidade  de doces  possível  seja  coletada,  ou  seja,  para  que Eduardo e Maria, somados,
terminem o jogo com o maior número possível de doces, qual deve sero valor de x sorteado, entre os valores abaixo?
(A)15
(B)20
(C)14
(D)16
(E)32
-}

somaDoces :: Int -> Int -> Int
somaDoces 0 x = x
somaDoces d x 
  | d `mod` 2 == 0 = somaDoces (div d 2) (x+1)
  | otherwise = somaDoces (d-1) (x+1)

{-A função somaDoces soma os doces que cada um terá no final, assim é só colocar no primeiro parâmetro o numero de doces sorteados
e no segundo parâmetro um 0, que significa o numero inicial de doces. Nesse caso a resposta correta é a letra A
que resulta em 7 doces.
>somaDoces 15 0 
-}
