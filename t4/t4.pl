% rel é relacionamento (homem,mulher)

rel(bernardo,anita).
rel(bernardo,caren).
rel(pedro,anita).
rel(pedro,alice).
rel(henrique,alice).
rel(henrique,maria).
rel(adriano,maria).
rel(adriano,caren).

% sm é Santa Maria (dia,pessoa)
sm(segunda,pedro).
sm(terca,pedro).
sm(quinta,pedro).
sm(quinta,caren).
sm(quinta,bia).
sm(quarta,adriano).
sm(segunda,bernardo).
sm(terca,bernardo).
sm(quinta,bernardo).
sm(terca,maria).
sm(quarta,maria).
sm(quinta,maria).

% poa é Porto Alegre (dia,pessoa)
poa(quarta,pedro).
poa(segunda,caren).
poa(terca,caren).
poa(quarta,caren).
poa(terca,henrique).
poa(terca,bia).
poa(quarta,bia).
poa(terca,alice).
poa(quarta,alice).
poa(quarta,bernardo).

% apart é o apartamento (dia,pessoa)
apart(sexta,pedro).
apart(sexta,caren).
apart(segunda,henrique).
apart(quarta,henrique).
apart(quinta,henrique).
apart(sexta,henrique).
apart(segunda,bia).
apart(sexta,bia).
apart(segunda,adriano).
apart(terca,adriano).
apart(quinta,adriano).
apart(sexta,adriano).
apart(segunda,alice).
apart(quinta,alice).
apart(sexta,alice).
apart(sexta,bernardo).
apart(segunda,maria).
apart(sexta,maria).

pobre(bernardo).
pobre(bia).
pobre(pedro).
pobre(maria).

rico(caren).
rico(alice).
rico(henrique).
rico(adriano).


ciume(alice,anita).
ciume(caren,anita).

insanidade(adriano).
insanidade(maria).

chave(bia).
chave(X):- sm(segunda,X); poa(terca,X).

bastao(X):- poa(quinta,X); sm(quarta,X).
martelo(X):- apart(quarta,X); apart(quinta,X).
arma(X):- bastao(X) ; martelo(X).

dinheiro(X) :- pobre(X).

accesso(X) :- chave(X), arma(X), (apart(quinta,X); apart(sexta,X)).

motivo(X):- dinheiro(X); ciume(X,anita); insanidade(X).

assassino(X):- motivo(X), accesso(X), !.