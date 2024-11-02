CREATE TABLE IF NOT EXISTS "produto_servico" (
	"id" UUID NOT NULL UNIQUE,
	"nome" TEXT NOT NULL,
	"descricao" TEXT,
	"preco" DECIMAL NOT NULL,
	"tipo" TEXT NOT NULL,
	PRIMARY KEY("id")
);


CREATE TABLE IF NOT EXISTS "pedido" (
	"id" UUID NOT NULL UNIQUE,
	"valor_total" DECIMAL NOT NULL,
	"situacao" TEXT NOT NULL,
	PRIMARY KEY("id")
);


CREATE TABLE IF NOT EXISTS "itens_pedido" (
	"id" UUID NOT NULL UNIQUE,
	"produto_servico_id" UUID NOT NULL,
	"pedido_id" UUID NOT NULL,
	"percentual_desconto" DECIMAL,
	"quantidade" INTEGER NOT NULL,
	PRIMARY KEY("id"),
    FOREIGN KEY("pedido_id") REFERENCES "pedido"("id")
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY("produto_servico_id") REFERENCES "produto_servico"("id")
        ON UPDATE NO ACTION ON DELETE NO ACTION
);
