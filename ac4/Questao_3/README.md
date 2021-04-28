## Questão 3 
#### Um aeroporto quer simular o tráfego aéreo com eventos como decolagens e pousos. Os eventos têm um time-stamp com a hora em que o evento acontece. O simulador deve realizar eficientemente as duas operações fundamentais a seguir:
####     a) inserir um evento com um dado time-stamp (ou seja, inserir um evento futuro);
####     b) extrair o evento com menor time-stamp (ou seja, determinar o próximo evento a processar);
#### Que estrutura de dados você usaria para suportar essas operações? Justifique sua resposta.

#### Reposta:
####   Utilizaria a estrutura de Fila de Prioridade. Com o uso do inserir para armazenar os time-stamp, poderia utilizar o comparador para extrair o com menor tempo e assim estabelecer qual o melhor evento na fila de pousos e decolagens.
