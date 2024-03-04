package library.modules.elements.webtables;

public enum ColumnName {
    FIRST_NAME{
        public String createColumnName(){
            return "First Name";
        }
    },
    LAST_NAME{
        public String createColumnName(){
            return "Last Name";
        }
    },
    AGE{
        public String createColumnName(){
            return "Age";
        }
    },
    EMAIL{
        public String createColumnName(){
            return "Email";
        }
    },
    SALARY{
        public String createColumnName(){
            return "Salary";
        }
    },
    DEPARTMENT{
        public String createColumnName(){
            return "Department";
        }
    };

    public abstract String createColumnName();
}
