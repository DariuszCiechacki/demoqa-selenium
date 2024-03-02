package library.modules.webtables;

public enum SortingType {
    ASC{
        public String createSortingType(){
            return "-sort-asc";
        }
    },

    DSC{
        public String createSortingType(){
            return "-sort-dsc";
        }
    };

    public abstract String createSortingType();
}
