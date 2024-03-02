package library.modules.webtables;

public enum SortingType {
    ASC{
        public String createSortingType(){
            return "-sort-asc";
        }
    },

    DESC {
        public String createSortingType(){
            return "-sort-desc";
        }
    };

    public abstract String createSortingType();
}
