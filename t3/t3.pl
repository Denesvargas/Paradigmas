% Exercicio 1
zeroInit(L) :-  L = [H|_], H is 0.

% Exercicio 2
has5(L) :- L = [_,_,_,_,_].

% Exercício 3
hasN(L,N) :- length(L,N).

% Exercício 4
potN0(0,[1]).
potN0(N,L) :- 
    N > 0,
    L = [H1|T1],
    H1 is 2**N,
    N1 is N-1,
    potN0(N1,T1).
