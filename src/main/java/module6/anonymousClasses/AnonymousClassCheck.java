package module6.anonymousClasses;

 class AnonymousClassCheck {
    public static void main(String[] args) {

        Parent parent = new Parent("Tom") {

            public String getParentName() {
                return super.getParentName();
            }

            public String getFunnyName() {
                return "Tominator";
            }
        };

        //Cannot call new method getFunnyName()
        //System.out.println("parent.getParentName() = "+ parent.getFunnyName());
        System.out.println("parent.getClass() = " + parent.getClass());

        System.out.println("================");

        var parentVar = new Parent("Tom") {
            public String getFunnyName() {
                return "Tominator";
            }
        };

        //Can call new method getFunnyName()
        System.out.println("parentVar.getFunnyName() = " + parentVar.getFunnyName());
        System.out.println("parentVar.getClass() = " + parentVar.getClass());

    }

    static class Parent {
        String parentName;

        public Parent(String parentName) {
            this.parentName = parentName;
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }
    }


}
