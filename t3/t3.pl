% Exercicio 1
zeroInit(L) :-  L = [H|_], H is 0.

% Exercicio 2
has5(L) :- L = [_,_,_,_,_].

% Exercício 3
hasN(L,N) :- length(L,N).
