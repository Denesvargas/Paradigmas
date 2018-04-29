/* Questão da OBI de 2011 Fase 1 - Modalidade Iniciação, Nível 1
link da pagina da OBI 2011: https://olimpiada.ic.unicamp.br/passadas/OBI2011/fase1/iniciacao/
link da Prova: https://olimpiada.ic.unicamp.br/static/extras/obi2011/provas/ProvaOBI2011_f1i1.pdf

Questão 1 -> Processadores
O processador é o componente mais importante de um computador. Uma medida da velocidade de um
processador é o número de operações básicas, como somas e multiplicações, que ele consegue realizar por
segundo (processadores usados em computadores pessoais são capazes de realizar bilhões de operações
por segundo). José Carlos está fazendo um estudo sobre as velocidades dos seguintes processadores
existentes no mercado: R, S, T, U, V, X, Y e Z. Através de experimentos, José Carlos determinou as
seguintes condições:

• O processador X é mais veloz do que os processadores T e Z.
• O processador Z é mais veloz do que os processadores T e Y.
• O processador T é mais veloz do que o processador R.
• O processador R é mais veloz do que o processador V.
• O processador Y é mais veloz do que o processador V.
• O processador U é mais veloz do que o processador R mas é mais lento do que o processador S
*/

% regras/condições
mveloz(x,t).
mveloz(x,z).
mveloz(z,t).
mveloz(z,y).
mveloz(t,r).
mveloz(r,v).
mveloz(y,v).
mveloz(u,r).
mveloz(s,u).


melhor(X) :- mveloz(_,X), !.

% questão 1  
/*Questão 1. Qual dos processadores seguintes
pode ser o mais veloz?
(A) V
(B) R
(C) U
(D) S
(E) Z
mrapido([v,r,u,s,z],Y).
resposta D é a correta. 
*/

mrapido([],[]).
mrapido([H|T],Y) :- 
    melhor(H),
    mrapido(T,Y), !.

mrapido([H|T],Y) :- mrapido(T,Y2), Y = [H|Y2], !.
