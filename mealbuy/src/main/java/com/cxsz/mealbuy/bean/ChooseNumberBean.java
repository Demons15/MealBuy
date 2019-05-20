package com.cxsz.mealbuy.bean;

import java.util.List;

public class ChooseNumberBean {

    /**
     * body : {"lastPage":8,"navigatepageNums":[1,2,3,4,5,6,7,8],"startRow":21,"hasNextPage":true,"prePage":2,"nextPage":4,"endRow":30,"pageSize":10,"list":[{"carrierOperator":"1","iccid":"898602B0131340173972","simId":"11758493","imsi":"000000000000000","settlementMode":"1","cardNumber":"1064801310371","ROW_ID":21},{"carrierOperator":"1","iccid":"898602B0131340173973","simId":"11758494","imsi":"000000000000000","settlementMode":"1","cardNumber":"1064801310372","ROW_ID":22},{"carrierOperator":"1","iccid":"898602B0131340173974","simId":"11758495","imsi":"000000000000000","settlementMode":"1","cardNumber":"1064801310373","ROW_ID":23},{"carrierOperator":"1","iccid":"898602B3131650578673","simId":"12107841","imsi":"0000000000000000","settlementMode":"1","cardNumber":"1064837798673","ROW_ID":24},{"carrierOperator":"1","iccid":"898602B0131340173970","simId":"11758491","imsi":"000000000000000","settlementMode":"1","cardNumber":"1064801310369","ROW_ID":25},{"carrierOperator":"1","iccid":"898602B3131690478140","simId":"12024908","imsi":"00000000000000","settlementMode":"1","cardNumber":"1064834881640","ROW_ID":26},{"carrierOperator":"1","iccid":"898602B0131340173971","simId":"11758492","imsi":"000000000000000","settlementMode":"1","cardNumber":"1064801310370","ROW_ID":27},{"carrierOperator":"1","iccid":"898602B3131650578607","simId":"12107775","imsi":"0000000000000000","settlementMode":"1","cardNumber":"1064837798607","ROW_ID":28},{"carrierOperator":"1","iccid":"898602B3131690478143","simId":"12024911","imsi":"00000000000000","settlementMode":"1","cardNumber":"1064834881643","ROW_ID":29},{"carrierOperator":"1","iccid":"898602B3131690478148","simId":"12024916","imsi":"00000000000000","settlementMode":"1","cardNumber":"1064834881648","ROW_ID":30}],"pageNum":3,"navigatePages":8,"navigateFirstPage":1,"total":75247,"pages":7525,"firstPage":1,"size":10,"isLastPage":false,"hasPreviousPage":true,"navigateLastPage":8,"isFirstPage":false}
     * code : 1
     */

    private BodyBean body;
    private int code;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class BodyBean {
        /**
         * lastPage : 8
         * navigatepageNums : [1,2,3,4,5,6,7,8]
         * startRow : 21
         * hasNextPage : true
         * prePage : 2
         * nextPage : 4
         * endRow : 30
         * pageSize : 10
         * list : [{"carrierOperator":"1","iccid":"898602B0131340173972","simId":"11758493","imsi":"000000000000000","settlementMode":"1","cardNumber":"1064801310371","ROW_ID":21},{"carrierOperator":"1","iccid":"898602B0131340173973","simId":"11758494","imsi":"000000000000000","settlementMode":"1","cardNumber":"1064801310372","ROW_ID":22},{"carrierOperator":"1","iccid":"898602B0131340173974","simId":"11758495","imsi":"000000000000000","settlementMode":"1","cardNumber":"1064801310373","ROW_ID":23},{"carrierOperator":"1","iccid":"898602B3131650578673","simId":"12107841","imsi":"0000000000000000","settlementMode":"1","cardNumber":"1064837798673","ROW_ID":24},{"carrierOperator":"1","iccid":"898602B0131340173970","simId":"11758491","imsi":"000000000000000","settlementMode":"1","cardNumber":"1064801310369","ROW_ID":25},{"carrierOperator":"1","iccid":"898602B3131690478140","simId":"12024908","imsi":"00000000000000","settlementMode":"1","cardNumber":"1064834881640","ROW_ID":26},{"carrierOperator":"1","iccid":"898602B0131340173971","simId":"11758492","imsi":"000000000000000","settlementMode":"1","cardNumber":"1064801310370","ROW_ID":27},{"carrierOperator":"1","iccid":"898602B3131650578607","simId":"12107775","imsi":"0000000000000000","settlementMode":"1","cardNumber":"1064837798607","ROW_ID":28},{"carrierOperator":"1","iccid":"898602B3131690478143","simId":"12024911","imsi":"00000000000000","settlementMode":"1","cardNumber":"1064834881643","ROW_ID":29},{"carrierOperator":"1","iccid":"898602B3131690478148","simId":"12024916","imsi":"00000000000000","settlementMode":"1","cardNumber":"1064834881648","ROW_ID":30}]
         * pageNum : 3
         * navigatePages : 8
         * navigateFirstPage : 1
         * total : 75247
         * pages : 7525
         * firstPage : 1
         * size : 10
         * isLastPage : false
         * hasPreviousPage : true
         * navigateLastPage : 8
         * isFirstPage : false
         */

        private int lastPage;
        private int startRow;
        private boolean hasNextPage;
        private int prePage;
        private int nextPage;
        private int endRow;
        private int pageSize;
        private int pageNum;
        private int navigatePages;
        private int navigateFirstPage;
        private int total;
        private int pages;
        private int firstPage;
        private int size;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private int navigateLastPage;
        private boolean isFirstPage;
        private List<Integer> navigatepageNums;
        private List<ListBean> list;

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(int navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public int getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(int navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * carrierOperator : 1
             * iccid : 898602B0131340173972
             * simId : 11758493
             * imsi : 000000000000000
             * settlementMode : 1
             * cardNumber : 1064801310371
             * ROW_ID : 21
             */

            private String carrierOperator;
            private String iccid;
            private String simId;
            private String imsi;
            private String settlementMode;
            private String cardNumber;
            private int ROW_ID;

            public String getCarrierOperator() {
                return carrierOperator;
            }

            public void setCarrierOperator(String carrierOperator) {
                this.carrierOperator = carrierOperator;
            }

            public String getIccid() {
                return iccid;
            }

            public void setIccid(String iccid) {
                this.iccid = iccid;
            }

            public String getSimId() {
                return simId;
            }

            public void setSimId(String simId) {
                this.simId = simId;
            }

            public String getImsi() {
                return imsi;
            }

            public void setImsi(String imsi) {
                this.imsi = imsi;
            }

            public String getSettlementMode() {
                return settlementMode;
            }

            public void setSettlementMode(String settlementMode) {
                this.settlementMode = settlementMode;
            }

            public String getCardNumber() {
                return cardNumber;
            }

            public void setCardNumber(String cardNumber) {
                this.cardNumber = cardNumber;
            }

            public int getROW_ID() {
                return ROW_ID;
            }

            public void setROW_ID(int ROW_ID) {
                this.ROW_ID = ROW_ID;
            }
        }
    }
}
