public List<List<String>> read() {

        // 返却用リスト箱作成
        List<List<String>> ret = new ArrayList<List<String>>();
        if (fileName != null) {
            System.out.println("fileName" + fileName);
            String inputCsvFile = "C:\\pleiades\\workspace\\hasuike\\jspServlet\\WebContent\\csv\\test1.csv";
            File csv = new File(inputCsvFile);
            System.out.println(csv);

            BufferedReader br = null;

            try {
                int lineCount = 0;
                // ファイルオープン
                 br = new BufferedReader(new FileReader(csv));

                // num行読み込む（0の場合は全行）
                String line = "";
                int idx = 0;
                while ((line = br.readLine()) != null) {
                    lineCount++;

                    // 1行を格納する箱作成
                    List<String> tmpList = new ArrayList<String>();

                    // 文字列index
                    int idxFrom = 0;
                    int idxTo = 0;
                    // 文字列長
                    while (true) {

                        // 最終項目を取得後は終了
                        if (idxFrom > line.length()) {
                            break;
                        }

                        // 次のセパレータ位置を取得
                        idxTo = line.indexOf(",", idxFrom);

                        // セパレータが発見できない場合は最終項目を取得
                        if (idxTo == -1) {
                            idxTo = line.length();
                        }

                        // 文字列取得
                        String word = line.substring(idxFrom, idxTo);

                        // 文字列を格納
                        tmpList.add(word);

                        // 検索開始位置を更新
                        idxFrom = idxTo + 1;
                    }

                    // 返却用リストに1行データを格納
                    ret.add(tmpList);

                    // numを超えたら読み込み終了。numが0のときは全量読む。
                    if (lineCount != 0 && idx > lineCount) {

                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }