export class MovieDB{
    private BASEURL  :string;
    private APIKEY   :string;
    private REGION   :string;
    private LANGUAGE :string;
    private static movieDB:MovieDB;
    private constructor(){
        this.BASEURL  = "https://api.themoviedb.org/3/";
        this.APIKEY   = "bdf04a42330733fdfeb4cbc860ab26d0";
        this.REGION   = "US";
        this.LANGUAGE = "en-US";
    }
    public static getMovieDB():MovieDB{
        if(MovieDB.movieDB == undefined){
            MovieDB.movieDB = new MovieDB();
        }
        return MovieDB.movieDB;
    }
    public getBASEURL():string{
        return this.BASEURL;
    }
    public getAPIKEY():string{
        return this.APIKEY;
    }
    public getREGION():string{
        return this.REGION;
    }
    public getLANGUAGE():string{
        return this.LANGUAGE;
    }

}