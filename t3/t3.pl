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

% Exercício 5
zipmult([],[],[]).
zipmult(L1,L2,L3) :-
    L1 = [H1|T1],
    L2 = [H2|T2],
    L3 = [H3|T3],
    H3 is H1*H2,
    zipmult(T1,T2,T3).

% Exercício 6
potencias(N,L) :-
    N >= 0,
    pot(N,0,L).
    
pot(N,N,[]).
pot(N,J,L) :-
    L = [H1|T1],
    H1 is 2**J,
    JF is J+1,
    pot(N,JF,T1).

% Exercício 7
positivos([],[]).
positivos(L1,L2) :-
    L1 = [H1|T1],
    L2 = [H2|T2],
    (H1 > 0 -> H2 is H1, positivos(T1,T2); positivos(T1,L2)).
