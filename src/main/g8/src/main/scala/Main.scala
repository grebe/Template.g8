package $top;format="Camel"$
import ChiselDSP._
case class GeneratorParams(complex: ComplexParams = ComplexParams(),
                           clock: ClockParams = ClockParams(),
                           $top$: $top;format="Camel"$Params = $top;format="Camel"$Params()       // Add your parameters here
                          ) extends JSONParams(complex, clock)

object Main {
  def main(args: Array[String]): Unit = {
    // Generator parameters + fixed/double mode setup
    val (isFixed,p) = Init({GeneratorParams()}, jsonName = "Demod", args = args)

    // Setup module + tester
    val runargs = args.slice(1, args.length)
    if (isFixed)
      Chisel.chiselMainTest(runargs, () => DSPModule(new $top;format="Camel"$({DSPFixed()},p.$top$))) { c => new $top;format="Camel"$Tester(c) }
    else
      Chisel.chiselMainTest(runargs, () => DSPModule(new $top;format="Camel"$({DSPDbl()},p.$top$))) { c => new $top;format="Camel"$Tester(c) }
  }
}

