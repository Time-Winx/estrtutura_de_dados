## 7) Descreva a saída resultante da seguinte série de operações de pilha: push(5), push(3), pop( ),push(2), push(8), pop( ), pop( ), push(9), push(1), pop( ), push(7), push(6), pop(),pop(), push(4), pop(), pop( ).  

### Resposta: (5)

Entrada | Saída | Conteúdo
--------|-------|---------
Push(5) |       |(5)
Push(3) |       |(5,3)
Pop()   |  3    |(5)
Push(2) |       |(5,2)
Push(8) |       |(5,2,8)
Pop()   |   8   |(5,2)
Pop()   |   2   |(5)
Push(9) |       |(5,9)
Push(1) |       |(5,9,1)
Pop()   |   1   |(5,9)
Push(7) |       |(5,9,7) 
Push(6) |       |(5,9,7,6)
Pop()   |   6   |(5,9,7)
Pop()   |   7   |(5,9)
Push(4) |       |(5,9,4)
Pop()   |   4   |(5,9)
Pop     |   9   |(5)

