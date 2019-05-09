pontas(X, [H|T]):- last([H|T],X); H = X .

aoLado(X,Y,List):- nextto(X,Y,List); nextto(Y,X,List).
% https://rachacuca.com.br/logica/problemas/navios-no-porto/
% navio(Nacio,Saida,Carg,Chaminé,Destino)

solucao(Navios):-
	Navios = [_,_,_,_,_],
	[_,_,navio(_,_,_,preta,_),_,_] = Navios,
	member(navio(ingles,9,_,_,_), Navios),
	nextto(navio(frances,_,_,azul,_), navio(_,_,cafe,_,_), Navios),
	nextto(navio(_,_,cacau,_,_), navio(_,_,_,_,macau), Navios),
	aoLado(navio(_,_,arroz,_,_), navio(_,_,_,verde,_), Navios),
	member(navio(_,5,_,_,santos), Navios),
	nextto(navio(_,_,_,_,macau), navio(espanhol,7,_,_,_), Navios),
	member(navio(_,_,_,vermelha,hamburgo), Navios),
	aoLado(navio(_,7,_,_,_), navio(_,_,_,branca,_), Navios),
	pontas(navio(_,_,milho,_,_), Navios),
	member(navio(_,8,_,preta,_), Navios),
	aoLado(navio(_,_,milho,_,_), navio(_,_,arroz,_,_), Navios),
	member(navio(_,6,_,_,hamburgo), Navios),
	member(navio(grego,6,cafe,_,_), Navios),
	member(navio(brasileiro,_,_,_,manila), Navios),
	member(navio(_,_,cha,_,_), Navios),
	member(navio(_,_,_,_,rotterdam), Navios).
