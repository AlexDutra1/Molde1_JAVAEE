Em Execução:

Ambiente Bootstrap montado
Marcação de 1 coluna no corpo da pagina com Bootstrap
Ambiente CDI montado
Classes do pacote de modelo com padrão JAVABEANS
Redirecionamento dependendo do retorno, configurado no FacesConfig
Usando Facelts com templates
Metodo init() com @PostConstruct
=====================================================
Exemplos com componentes web:

input
combobox
radiobutton
checkbox
=====================================================
Exemplo com os relacionamentos:

Cliente x Endereco

Um x Um

Leitura:
Um cliente tem um endereco apenas
Um endereco pode te um cliente apenas 

-------------------------------------
Cliente x Telefones
Um x Muitos

Um Cliente por ter um ou mais telefones
Resultado: N

Um telefone pode ter somente um Cliente
Resultado: 1

-------------------------------------
Endereço x Estado

Um x Muitos

Leitura:
Um endereço pode ter um estado
Resultado: 1

Um estado pode ter um ou mais endereços
Resultado: N


-----------------------------------
Clientes x Interesses

Um cliente tem quantos interesses?
No minimo 1 e no maximo N
Resultado: N

Um interesse tem quantos clientes?
No minimo 0 e no maximo N
Resultado N

Muitos x Muitos
=====================================================
Exemplo com a relação TEM-UM de 4 nivel

Cliente TEM-UM Endereço que TEM-UM Estado que TEM-UMA Cidade
=====================================================
Exemplo com os tipos de dados:

Date
BigDecimal
Lob (Para imagens e outros arquivos binarios)
=====================================================
Tecnologias:

Maven
Bootstrap
CDI
JSF
PrimeFaces
JPA
=====================================================
Configuração do Ambiente:

Eclipse Luna
PostgreeSQL 9.4.5
Tomcat 8.0
Dynamic Web Module 3.1
JRE 1.7