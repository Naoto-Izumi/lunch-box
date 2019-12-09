protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        CSVReader csvReading;
        String fileName;
        T001ItemDao itemDao;
        String nextPage = "";

        String name = request.getParameter("name");
        String code = request.getParameter("code");
        // //金額の取得
        String unitPrice = request.getParameter("unitPrice");
        // 数量の取得
        String count = request.getParameter("count");
        String isPR = request.getParameter("isPR");
        String img = request.getParameter("image");
        ServletContext con = getServletConfig().getServletContext();

        csvReading = new CSVReader();
        csvReading.csvAdd(request,con);

        List<List<String>> csvResult = csvReading.read();


            for(int i = 4; i < csvResult.size(); i++) {
                if (null != csvResult.get(i)) {
                    for (int j = 0; j < csvResult.get(i).size(); j++) {
                        System.out.println("csvResult"+csvResult.get(i).get(j));
                        if (0 == (i % 4)){

                            try {
                                itemDao = new T001ItemDao();
                                int itembean = itemDao.update(code, name, unitPrice, count);
                                request.setAttribute("itembean", itembean);
                                nextPage = "/list.jsp";
                            } catch (ClassNotFoundException e) {
                                // TODO 自動生成された catch ブロック
                                e.printStackTrace();
                            } catch (SQLException e) {
                                // TODO 自動生成された catch ブロック
                                e.printStackTrace();
                            }

                        }else{
                            try {
                                itemDao = new T001ItemDao();
                                int result = itemDao.addItem(name, unitPrice, count,isPR,img);
                                if (result == 1) {
                                    nextPage = "/list.jsp";
                                } else {
                                    nextPage = "/add.jsp";
                                }
                            } catch (ClassNotFoundException e) {
                                // TODO 自動生成された catch ブロック
                                e.printStackTrace();
                            } catch (SQLException e) {
                                // TODO 自動生成された catch ブロック
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }

        System.out.println("csvResult"+csvResult);
    }