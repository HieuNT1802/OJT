public class test {

    public static void main(String[] args) {
  try{
      throw  new Exception();

  }catch (Exception e){
      try{
          throw  new Exception();
      } catch (Exception e2){
          System.out.println("inner");
      }
      System.out.println("midd");
  }
        System.out.println("outer");
    }

}
