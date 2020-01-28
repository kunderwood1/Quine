public class SelfRep {
    static final char quote = '"';
    static final char escape = '\\';
    public static String quote (String s) {
        int i;
        StringBuffer buf = new StringBuffer ();
        for ( i=0 ; i<s.length() ; i++ ) {
            if ( ( s.charAt (i) == quote )
                    || ( s.charAt (i) == escape ) )
                buf.append (escape);
            buf.append (s.charAt (i));
        }
        return buf.toString ();
    }
    static public class QuineData {
        static final String qline1 = "	    \"";
        static final String qline2 = "\",";
        String predata[];
        String meddata[];
        String postdata[];
        public QuineData (String predata[], String meddata[],
                          String postdata[]) {
            this.predata = predata;
            this.meddata = meddata;
            this.postdata = postdata;
        }
        public void quine () {
            int i;
            for ( i=0 ; i<predata.length ; i++ )
                System.out.println (predata[i]);
            for ( i=0 ; i<predata.length ; i++ ) {
                System.out.print (qline1);
                System.out.print (quote (predata[i]));
                System.out.println (qline2);
            }
            for ( i=0 ; i<meddata.length ; i++ )
                System.out.println (meddata[i]);
            for ( i=0 ; i<postdata.length ; i++ ) {
                System.out.print (qline1);
                System.out.print (quote (postdata[i]));
                System.out.println (qline2);
            }
            for ( i=0 ; i<postdata.length ; i++ )
                System.out.println (postdata[i]);
        }
    }
    public static void main (String[] args) {
        String predata[] = {
                "public class SelfRep {",
                "    static final char quote = '\"';",
                "    static final char escape = '\\\\';",
                "    public static String quote (String s) {",
                "	int i;",
                "	StringBuffer buf = new StringBuffer ();",
                "	for ( i=0 ; i<s.length() ; i++ ) {",
                "	    if ( ( s.charAt (i) == quote )",
                "		 || ( s.charAt (i) == escape ) )",
                "		buf.append (escape);",
                "	    buf.append (s.charAt (i));",
                "	}",
                "	return buf.toString ();",
                "    }",
                "    static public class QuineData {",
                "	static final String qline1 = \"	    \\\"\";",
                "	static final String qline2 = \"\\\",\";",
                "	String predata[];",
                "	String meddata[];",
                "	String postdata[];",
                "	public QuineData (String predata[], String meddata[],",
                "			  String postdata[]) {",
                "	    this.predata = predata;",
                "	    this.meddata = meddata;",
                "	    this.postdata = postdata;",
                "	}",
                "	public void quine () {",
                "	    int i;",
                "	    for ( i=0 ; i<predata.length ; i++ )",
                "		System.out.println (predata[i]);",
                "	    for ( i=0 ; i<predata.length ; i++ ) {",
                "		System.out.print (qline1);",
                "		System.out.print (quote (predata[i]));",
                "		System.out.println (qline2);",
                "	    }",
                "	    for ( i=0 ; i<meddata.length ; i++ )",
                "		System.out.println (meddata[i]);",
                "	    for ( i=0 ; i<postdata.length ; i++ ) {",
                "		System.out.print (qline1);",
                "		System.out.print (quote (postdata[i]));",
                "		System.out.println (qline2);",
                "	    }",
                "	    for ( i=0 ; i<postdata.length ; i++ )",
                "		System.out.println (postdata[i]);",
                "	}",
                "    }",
                "    public static void main (String[] args) {",
                "	String predata[] = {",
        };
        String postdata[] = {
                "	};",
                "	String meddata[] = {",
                "	    \"	};\",",
                "	    \"	String postdata[] = {\",",
                "	};",
                "	QuineData prog = new QuineData (predata, meddata, postdata);",
                "	prog.quine();",
                "    }",
                "}",
        };
        String meddata[] = {
                "	};",
                "	String postdata[] = {",
        };
        QuineData prog = new QuineData (predata, meddata, postdata);
        prog.quine();
    }
}
