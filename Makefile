SRC_DIR		:=	src
BIN_DIR		:=	bin

MAIN_CLASS	:=	avaj.launcher.Main

SOURCES		:=	$(shell find $(SRC_DIR) -type f -name \*.java)
CLASSES		:=	$(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

all: $(CLASSES)

run: $(CLASSES)
	java -cp $(BIN_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(BIN_DIR)

fclean: clean

$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	javac -d $(BIN_DIR) $<
