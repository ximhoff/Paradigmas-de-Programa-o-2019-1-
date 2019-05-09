ao_lado(X, Y, List) :- nextto(X, Y, List).
ao_lado(X, Y, List) :- nextto(Y, X, List).

% menina(Nome,Mochila,Materia,Animal,Lugar,Suco)
% https://rachacuca.com.br/logica/problemas/amigas-na-escola/

solucao(Meninas, Dona_Gato):-
	Meninas = [_,_,_,_,_],
	member(menina(joana,_,_,_,_,abacaxi), Meninas),
	member(menina(_,_,artes,hamsters,_,_), Meninas),
	member(menina(ana,_,_,_,_,limao), Meninas),
	nextto(menina(jessica,_,_,_,_,_),menina(renata,_,_,_,_,_),Meninas),
	[menina(pati,_,_,_,_,_)|_] = Meninas,
	[_,_,_,_,menina(_,_,artes,_,_,_)] = Meninas,
	member(menina(_,_,_,cavalos,_,laranja), Meninas),
	[_,_,menina(_,_,_,_,_,limao),_,_] = Meninas,
	member(menina(jessica,verde,_,_,_,_), Meninas),
	[_,menina(_,_,_,_,florianopolis,_),_,_,_] = Meninas,
	member(menina(_,amarela,_,_,recife,_), Meninas),
	ao_lado(menina(_,_,_,_,_,abacaxi), menina(_,_,_,_,fernandodenoronha,_), Meninas),
	member(menina(_,vermelha,_,_,fernandodenoronha,_), Meninas),
	[menina(_,amarela,_,_,_,_)|_] = Meninas,
	member(menina(_,azul,_,cachorros,_,_), Meninas),
	ao_lado(menina(_,_,biologia,_,_,_), menina(_,_,_,hamsters,_,_), Meninas),
	nextto(menina(_,_,historia,_,_,_), menina(_,_,matematica,_,_,_), Meninas),
	ao_lado(menina(_,_,_,_,_,laranja), menina(_,_,_,_,_,maracuja), Meninas),
	member(menina(_,preta,_,_,riodejaneiro,_), Meninas),
	member(menina(_,_,_,passaros,_,morango), Meninas),
	ao_lado(menina(_,_,biologia,_,_,_), menina(_,_,portugues,_,_,_), Meninas),
	member(menina(jessica,_,_,_,salvador,_), Meninas),
	member(menina(Dona_Gato,_,_,gato,_,_), Meninas).
