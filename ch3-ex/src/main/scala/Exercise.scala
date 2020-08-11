/*
 * This code is a minimal hardware described in Chisel.
 */

import chisel3._
import chisel3.Driver

/**
 * The mux component
 */

class Exercise extends Module {
  val io = IO(new Bundle {
    val sw = Input(UInt(3.W))
    val led = Output(UInt(1.W))
  })

  io.led := Mux(io.sw(0), io.sw(1), io.sw(2))
}

/**
 * An object extending App to generate the Verilog code.
 */
object Exercise extends App {
  chisel3.Driver.execute(Array("--target-dir", "target"), () => new Exercise())
}
