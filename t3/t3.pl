	odd(N):-
1 is mod(N,2).

	hasN([],0).
	hasN(L,N) :-
N > 0,
L = [C | T],
N1 is N - 1,
hasN(T,N1).

	inc99([],[]).
	inc99(L1,L2):-
L1 = [H|T],
L2 = [X|Y],
X is H+99,
inc99(T,Y).

	incN([],[],N).
	incN(L1,L2,N):-
L1 = [H|T],
L2 = [X|Y],
X is H + N,
incN(T,Y,N).

	comment([],[]).
	comment(L1,L2) :-
L1 = [H|T],
L2 = [X|Y],
string_concat("%%",H,X),
comment(T,Y).

	even(N):-
0 is mod(N,2).

	onlyEven([],[]).
	onlyEven(L1,L2):-
L1 = [H|T],
L2 = [X|Y],
even(H),
X = H,
onlyEven(T,Y).
	onlyEven(L1,L2):-
L1 = [H|T],
L2 = [X|Y],
odd(H),
onlyEven(T,L2).

	countdown(0,[]).
	countdown(N,L):-
L = [H|T],
N > 0,
H = N,
X is N-1,
countdown(X,T).

	nRandoms(0,[]).
	nRandoms(N,L):-
L=[H|T],
random(1,100,X),
H = X,
Y is N - 1,
nRandoms(Y,T).

	potN0(-1,[]).
	potN0(N,L):-
L=[H|T],
X is 2 ** N,
H = X,
Y is N - 1,
potN0(Y, T).

	zipmult([],[],[]).
	zipmult(L1,L2,L3):-
L1 = [H|T],
L2 = [X|Y],
L3 = [W|Z],
W is H * X,
zipmult(T,Y,Z).

	potencias(0,[]).
	potencias(N, L):-
potenciasaux(N,L,N).

	potenciasaux(N,[],0).
	potenciasaux(N,L,X):-
L=[H|T],
Y is N - X,
H is 2 ** Y,
W is X - 1,
potenciasaux(N,T,W).

	cedulas(0,[],[]).
	cedulas(V,L1,L2):-
L1 = [H|T],
L2 = [X|Y],
W is div(V,H),
X = W,
S is V - (W * H),
cedulas(S,T,Y). 
