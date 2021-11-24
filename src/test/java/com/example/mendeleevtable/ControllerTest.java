
    @Test
    public void toTableButton_Test(){
        String expected = "table opened";
        String actual = Controller.toTableButton(event, true);
        assertEquals(expected, actual);
    }

    @Test
    public void toGameButton_Test() throws IOException {
        String expected = "game frame opened";
        String actual = Controller.toGameButton(event, true);
        assertEquals(expected, actual);
    }

    @Test
    public void toElemInfo_Test() throws Exception {
        String expected = "info opened";
        String actual = Controller.goToElemInfo(event, true);
        assertEquals(expected, actual);
    }

    @Test
    public void backToMain_Test() {
        String expected = "main opened";
        String actual = Controller.backToMain(event, true);
        assertEquals(expected, actual);
    }


    @Test
    public void backToMain1_Test() {
        String expected = "main opened";
        String actual = Controller.backToMain1(event, true);
        assertEquals(expected, actual);
    }

    @Test
    public void backToTable_Test() {
        String expected = "info hided";
        String actual = Controller.backToTable(event, true);
        assertEquals(expected, actual);
    }

    @Test
    public void generateInfo_Test() {
        String expected = "info have been generated";
        String actual = Controller.generateInfo(1, true);
        assertEquals(expected, actual);
    }

