% Group 81
% Laurence Rawlings (991368)
% Fraser Grandfield (979248)
% Tobias Plunkett (981160)

% Questiion 1

% Program: ROYAL
parent(queenmother,elisabeth). 
parent(elisabeth,charles).
parent(elisabeth,andrew). 
parent(elisabeth,anne).
parent(elisabeth,edward). 
parent(diana,william).
parent(diana,harry). 
parent(sarah,beatrice).
parent(anne,peter). 
parent(anne,zara).
parent(george,elisabeth). 
parent(philip,charles).
parent(philip,andrew). 
parent(philip,edward).
parent(charles,william). 
parent(charles,harry).
parent(andrew,beatrice). 
parent(andrew,eugenie).
parent(mark,peter). 
parent(mark,zara).
parent(william,georgejun).
parent(kate,georgejun).
parent(william,charlotte). 
parent(kate,charlotte).
parent(philip,anne). 
parent(william,louis).
parent(kate,louis). 
parent(harry,archie).
parent(meghan,archie).

the_royal_females([queenmother,elisabeth,anne,diana,sarah,beatrice,zara,eugenie,charlotte,kate,meghan]).
the_royal_males([charles,andrew,edward,william,harry,peter,george,philip,mark,georgejun,louis,archie]).

%a)
the_royal_family(Royal) :-  the_royal_males(Males), the_royal_females(Females), append(Males, Females, Royals), subset(Royal, Royals).

%b)
father(Father, Child) :- parent(Father, Child), the_royal_males(Male), member(Father, Male).

%c)
granddad(Grandfather, Child) :- father(Grandfather, Father), parent(Father, Child).

%d)
has_child(Parent) :- parent(Parent, _).

%e)
ancestor(Ancestor, Person) :- parent(Ancestor, Person).
ancestor(Ancestor, Person) :- parent(Ancestor, Parent), parent(Parent, Person), ancestor(Ancestor, Parent).

%f)
sibling(Sibling1, Sibling2) :- parent(Parent, Sibling1), parent(Parent, Sibling2), Sibling1 \= Sibling2.

%g)
brother(Brother, Sibling) :- sibling(Brother, Sibling), the_royal_males(Male), member(Brother, Male).

%h)
% granddad(george, X).
% X = charles ;
% X = andrew ;
% X = anne ;
% X = edward ;

%i) 
% has_child(X).
% X = queenmother ;
% X = elisabeth ;
% X = elisabeth ;
% X = elisabeth ;
% X = elisabeth ;
% X = diana ;
% X = diana ;
% X = sarah ;
% X = anne ;
% X = anne ;
% X = george ;
% X = philip ;
% X = philip ;
% X = philip ;
% X = charles ;
% X = charles ;
% X = andrew ;
% X = andrew ;
% X = mark ;
% X = mark ;
% X = william ;
% X = kate ;
% X = william ;
% X = kate ;
% X = philip ;
% X = william ;
% X = kate ;
% X = harry ;
% X = meghan.

%j)
% ancestor(diana, X). 
% X = william ;
% X = harry ;
% X = georgejun ;
% X = charlotte ;
% X = louis ;
% X = archie ;

%k)
% ancestor(X, archie).
% X = harry ;
% X = meghan ;
% X = diana ;
% X = charles ;

%l)
has_brother_who_is_granddad(X, Y) :- brother(X, Y), granddad(X, Z).
% X = charles, Y = andrew ;
% X = charles, Y = andrew ;
% X = charles, Y = andrew ;
% X = charles, Y = andrew ;
% X = charles, Y = anne ;
% X = charles, Y = anne ;
% X = charles, Y = anne ;
% X = charles, Y = anne ;
% X = charles, Y = edward ;
% X = charles, Y = edward ;
% X = charles, Y = edward ;
% X = charles, Y = edward ;
% X = charles, Y = andrew ;
% X = charles, Y = andrew ;
% X = charles, Y = andrew ;
% X = charles, Y = andrew ;
% X = charles, Y = edward ;
% X = charles, Y = edward ;
% X = charles, Y = edward ;
% X = charles, Y = edward ;
% X = charles, Y = anne ;
% X = charles, Y = anne ;
% X = charles, Y = anne ;
% X = charles, Y = anne ;

% Question 2

%a)
toEven([], []).
toEven([H|T], L2) :- H mod 2 =:= 0 -> 
                     L2 = [H|T1],
                     toEven(T, T1);
                     P is H * 2,
                     L2 = [P|T1],
                     toEven(T, T1).

% 1 ?- toEven([1,2,3,4,5],L2).
% L2 = [2, 2, 6, 4, 10].

%b)
star(0).
star(N) :- N > 0,
           printStars(N),
           nl,
           N1 is N - 1,
           star(N1).        

printStars(0).
printStars(N) :- N > 0,
                 print(*),
                 N1 is N - 1,
                 printStars(N1).

starR(N, T) :-  N =< T,
                printStars(N),
                nl,
                N1 is N + 1,
                starR(N1, T).

star2(0).
star2(N) :- star(N),
            starR(2, N).

% 2 ?- star(3).
% ***
% **
% *
% true ;
% false.   
% 3 ?- star2(3).
% ***
% **
% *
% **
% ***
% false.

% Question 3

%a.
euclidsqr(X, Y, ED) :- length(X,Len),
                       euclidsqr(X, Y, Len, 0, ED).

euclidsqr(_, _, 0, ED, ED).
euclidsqr(X, Y, Len, Acc, ED) :- Len > 0,
                                 nth1(Len, X, XCurrent),
                                 nth1(Len, Y, YCurrent),
                                 Acc1 is Acc + ((XCurrent - YCurrent) * (XCurrent - YCurrent)),
                                 Len2 is Len - 1,
                                 euclidsqr(X, Y, Len2, Acc1, ED).

%b.
euclidsqr2(X, Y, ED) :- euclidsqr2(X, Y, 0, ED).

euclidsqr2([], [], ED, ED).
euclidsqr2([HX|TX], [HY|TY], Acc, ED) :- Acc1 is Acc + ((HX - HY) * (HX - HY)),
                                         euclidsqr2(TX, TY, Acc1, ED).

% Question 4

%a
member_rem(H, [H|T], T).
member_rem(X, [H|T], [H|R]) :- member_rem(X, T, R).

%b
gen_list_n(0, _, []).
gen_list_n(N, D, [X|Xs]) :- N > 0,
                            N1 is N - 1,
                            member_rem(X, D, D1),
                            gen_list_n(N1 ,D1, Xs).

gen4(L) :- gen_list_n(4, [1, 2, 3, 4], L).

%c
distinct_in_entries([], []).
distinct_in_entries([X|Xs], [Y|Ys]) :- X =\= Y,
                                       distinct_in_entries(Xs, Ys).

%d
gen_poss_soln([R1, R2, R3, R4]) :- gen4(R1),
                                   gen4(R2),
                                   distinct_in_entries(R1, R2),
                                   gen4(R3),
                                   distinct_in_entries(R1, R3),
                                   distinct_in_entries(R2, R3),
                                   gen4(R4),
                                   distinct_in_entries(R1, R4),
                                   distinct_in_entries(R2, R4),
                                   distinct_in_entries(R3, R4).
    
%e
solve([R1 ,R2, R3, R4]) :- gen_poss_soln([R1, R2, R3, R4]),
                           R1 = [R11, R12, _, _],
                           R2 = [R21, R22, _, R24],
                           R3 = [R31, R32, R33, R34],
                           R4 = [_, _, R43, R44],
                           R11 > R12,
                           R21 < R22,
                           R24 > R34,
                           R31 > R32,
                           R33 < R34,
                           R43 < R44.

%f
solve_in_steps([R1, R2, R3, R4]) :- gen4(R1),
                                    R1 = [R11, R12, _, _],
                                    R11 > R12,
                                    gen4(R2),
                                    distinct_in_entries(R1, R2),
                                    R2 = [R21, R22, _, R24],
                                    R21 < R22,
                                    gen4(R3),
                                    distinct_in_entries(R1, R3),
                                    distinct_in_entries(R2, R3),
                                    R3 = [R31, R32, R33, R34],
                                    R31 > R32,
                                    R33 < R34,
                                    R34 < R24,
                                    gen4(R4),
                                    R4 = [_, _, R43, R44],
                                    distinct_in_entries(R1, R4),
                                    distinct_in_entries(R2, R4),
                                    distinct_in_entries(R3, R4),
                                    R43 < R44.