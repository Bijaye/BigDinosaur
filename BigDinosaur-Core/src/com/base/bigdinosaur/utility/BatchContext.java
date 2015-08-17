package com.base.bigdinosaur.utility;



import java.io.Serializable;

public class BatchContext
    implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String language;
    private String pathteport;
    private String pathtexcel;
    public String getPathteport() {
        return pathteport;
    }



    public String getPathtexcel() {
        return pathtexcel;
    }



    public String getPathpdf() {
        return pathpdf;
    }



    public void setPathteport(String pathteport) {
        this.pathteport = pathteport;
    }



    public void setPathtexcel(String pathtexcel) {
        this.pathtexcel = pathtexcel;
    }



    public void setPathpdf(String pathpdf) {
        this.pathpdf = pathpdf;
    }

    private String pathpdf;
    

            public BatchContext()
            {
            }

         

   public String getLanguage()
   {
       return language;
   }

   public void setLanguage(String language)
   {
       this.language = language;
   }

          
}

