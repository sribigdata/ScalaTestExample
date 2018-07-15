under project strcture > src > main > scala >   
=========================================


import scala.collection.mutable


object ShoppingList {
  def apply(): ShoppingList = {
    new ShoppingList(Map("Cola" -> ListOfItem(0.50,"Cola"),
      "Coffee" -> ListOfItem(1.00, "Coffee"),
      "Cheese Sandwich" -> ListOfItem(2.00,"Cheese Sandwich"),
      "Steak Sandwich" -> ListOfItem(4.50,"Steak Sandwich")),
      Map("Cola" -> Discount(ListOfItem(0.50,"Cola"))));
  }
}
/*new ShoppingList(Map("Cola" -> ListOfItem.Cola(0.50,"Cola"),*/

class ShoppingList(val products: Map[String, ListOfItem], val Discountoffers: Map[String, Discount]) {
  var total = BigDecimal("0.00")

  val items = mutable.MutableList[ListOfItem]()
  def Add(item: String) = {

    products(item) match {
      case i: ListOfItem =>
        total += i.price
        items += i
    }
    Discountoffers.get(item) match {
      case o: Some[Discount] => items += o.get.freeItem
      case None =>
    }
  }
}
