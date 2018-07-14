package oberon.expression 
import oberon.visitor.Visitor 
abstract class BinExpression(val lhs: Expression , val rhs: Expression) extends Expression { }
class AddExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new IntValue(v1.value + v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TInt() && t2 ==TInt()) TInt() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class SubExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new IntValue(v1.value - v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TInt() && t2 ==TInt()) TInt() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class MultiExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new IntValue(v1.value * v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TInt() && t2 ==TInt()) TInt() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class DivExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new IntValue(v1.value / v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TInt() && t2 ==TInt()) TInt() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class ModExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new IntValue(v1.value % v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TInt() && t2 ==TInt()) TInt() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class NotEqExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new BoolValue(v1.value != v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TInt() && t2 ==TInt()) TInt() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class MinExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new BoolValue(v1.value < v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TInt() && t2 ==TInt()) TBool() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class BigExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new BoolValue(v1.value > v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TInt() && t2 ==TInt()) TBool() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class BigOrEqExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new BoolValue(v1.value >= v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TInt() && t2 ==TInt()) TBool() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class MinOrEqExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new BoolValue(v1.value <= v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TInt() && t2 ==TInt()) TBool() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class OrExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : BoolValue = lhs.eval().asInstanceOf[BoolValue]
    val v2 : BoolValue = rhs.eval().asInstanceOf[BoolValue]
   return new BoolValue(v1.value || v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TBool() && t2 ==TBool()) TBool() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class AndExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : BoolValue = lhs.eval().asInstanceOf[BoolValue]
    val v2 : BoolValue = rhs.eval().asInstanceOf[BoolValue]
   return new BoolValue(v1.value & v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TBool() && t2 ==TBool()) TBool() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class EqExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
    val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
   return new BoolValue(v1.value == v2.value )
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TBool() && t2 ==TBool()) TBool() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
class NotExpression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
  override
  def eval() : Value = { 
    val v1 : BoolValue = lhs.eval().asInstanceOf[BoolValue]
    val v2 : BoolValue = rhs.eval().asInstanceOf[BoolValue]
   return new BoolValue( ! v1.value)
  }
   override
   def calculateType() : Type = { 
   val t1 = lhs.calculateType()
   val t2 = lhs.calculateType()
   return if(t1 ==TBool() && t2 ==TBool()) TBool() else TUndefined() 
 } 
     override def accept(v: Visitor) {
     v.visit(this)
 }
}
