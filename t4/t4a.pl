%%% regra 1 
%cd Independente
%S ocupa a quarta faixa do CD.
regra1(L) :- nth1(4,L,s).

% regra 2
% Tanto W como Y precedem S no CD (ou seja, W e Y estão
% numa faixa que é tocada antes de S no CD).
regra2(L) :-
    nth0(P1,L,w),
    nth0(P2,L,y),
    nth0(P3,L,s),
    P1 < P3,
    P2 < P3,
    !.

% regra 3
% T precede W no CD (ou seja, T está numa faixa que é tocada antes de W).
regra3(L) :-
    nth0(P1,L,t),
    nth0(P2,L,w),
    P1 < P2,
    !.

% regra 4
% Um sucesso de rock ocupa a sexta faixa do CD.
sucesso(_).
regra4(L) :- L = [_,_,_,_,_,S,_], sucesso(S).

% regra 5
%  Cada sucesso de rock é imediatamente precedido no CD por uma
%  composição da banda (ou seja,no CD cada sucesso de rock toca
%  imediatamente após uma composição da banda).

banda(_).
regra5(L) :- sucesso(A), banda(B), nextto(B,A,L).
    
% regra 6
% Z é um sucesso de rock.
regra6(N) :- sucesso(N).
    
    
cdindependente(L) :-
    regra1(L),
	regra2(L),
    regra3(L),
    regra4(L),
    regra5(L),
    regra6(z),
    !.
    
/*Questão 11. Qual das seguintes alternativas poderia
  ser a ordem das músicas no CD, da primeira
  para a sétima faixa?
  (A) T, W, V, S, Y, X, Z - cdindependente([t,w,v,s,y,x,z]).
  (B) V, Y, T, S, W, Z, X - cdindependente([v,y,t,s,w,z,x]).
  (C) X, Y, W, S, T, Z, S - cdindependente([x,y,w,s,t,z,s]).
  (D) Y, T, W, S, X, Z, V - cdindependente([y,t,w,s,x,z,v]).
  (E) Z, T, X, W, V, Y, S - cdindependente([z,t,x,w,v,y,s]).
  correta é a letra D.
*/
