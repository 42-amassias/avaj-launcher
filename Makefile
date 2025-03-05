SRC_DIR			:=	src
BIN_DIR			:=	bin

MAIN_CLASS		:=	avaj.launcher.Main

SOURCES			:=	$(shell find $(SRC_DIR) -type f -name \*.java)
CLASSES			:=	$(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

SCENARIO_FILE	:=	subject/scenario.txt

all: $(CLASSES)

run: $(CLASSES)
	@java -cp $(BIN_DIR) $(MAIN_CLASS) $(SCENARIO_FILE)

clean:
	rm -rf $(BIN_DIR)

fclean: clean

$(CLASSES): $(SOURCES)
	javac -d $(BIN_DIR) $^
