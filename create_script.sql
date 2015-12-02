CREATE TABLE "pessoa" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`razao_social`	TEXT NOT NULL,
	`id_endereco`	INTEGER,
	`numero_endereco`	INTEGER,
	`complemento_endereco`	TEXT
);
CREATE TABLE "pessoa_fisica" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`cpf`	TEXT(11) NOT NULL,
	`rg`	INTEGER(10),
	`id_pessoa`	INTEGER(11) NOT NULL,
	`data_nascimento`	TEXT(10),
	`sexo`	TEXT(1)
);
CREATE TABLE "pessoa_juridica" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`cnpj`	TEXT(13) NOT NULL,
	`id_pessoa`	INTEGER(11) NOT NULL,
	`nome_fantasia`	TEXT(100),
	`inscricao_estadual`	INTEGER(11)
);
CREATE TABLE "telefone" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`id_pessoa`	INTEGER(11),
	`ddd`	INTEGER(3),
	`telefone`	TEXT(13),
	`descricao`	TEXT(100),
	`principal`	INTEGER(1)
);
CREATE TABLE "produto" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`ref`	TEXT(30),
	`ref_fornecedor`	TEXT(30),
	`descricao`	TEXT(100),
	`valor`	INTEGER(7,2),
	`lucro`	INTEGER(3,7),
	`quantidade`	INTEGER(10),
	`unidade`	TEXT(2),
	`ativo`	INTEGER(1)
);
CREATE TABLE "endereco" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`cep`	INTEGER(8),
	`logradouro`	TEXT(100),
	`bairro`	TEXT(100),
	`cidade`	TEXT(100),
	`uf`	TEXT(2)
);
CREATE TABLE "contato" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`id_pessoa`	INTEGER(11),
	`descricao`	TEXT(100),
	`contato`	TEXT(100)
);
CREATE TABLE "pedido" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`cnpj`	TEXT(13),
	`data`	TEXT(10),
	`observacao`	TEXT(300),
	`descricao`	TEXT(100)
);
CREATE TABLE "item_pedido" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`id_pedido`	INTEGER(11),
	`id_produto`	INTEGER(11),
	`quantidade`	INTEGER(10),
	`custo`	INTEGER(7,2)
);
CREATE TABLE "nota_fiscal" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`numero`	INTEGER(10) UNIQUE,
	`serie`	TEXT(1),
	`chave_acesso`	TEXT(44) UNIQUE,
	`entrada_saida`	INTEGER(1),
	`natureza_operacao`	TEXT(100),
	`data_emissao`	TEXT(10),
	`data_entrada_saida`	TEXT(10),
	`id_pessoa`	INTEGER(11),
	`informacoes_complementares`	TEXT(300)
);
CREATE TABLE "item_nf" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`id_nf`	INTEGER(11),
	`id_produto`	INTEGER(11),
	`quantidade`	INTEGER(10),
	`custo`	INTEGER(7,2)
);