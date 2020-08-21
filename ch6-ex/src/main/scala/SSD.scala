/*
 * This code is a minimal hardware described in Chisel.
 *
 * Blinking LED: the FPGA version of Hello World
 */

import chisel3._
import chisel3.util._

/**
 * The blinking LED component.
 */

class SSDBundle extends Bundle {
  val a = Bool()
  val b = Bool()
  val c = Bool()
  val d = Bool()
  val e = Bool()
  val f = Bool()
  val g = Bool()
}

class SSD extends Module {
  val io = IO(new Bundle {
    val digit = Input(UInt(4.W))
    val enable = Input(Bool())
    val dec = Output(new SSDBundle())
  })

  io.dec.a := false.B
  io.dec.b := false.B
  io.dec.c := false.B
  io.dec.d := false.B
  io.dec.e := false.B
  io.dec.f := false.B
  io.dec.g := false.B

  when (io.enable === true.B) {
    switch (io.digit) {
      is ("b0000".U) {
        io.dec.a := true.B
        io.dec.b := true.B
        io.dec.c := true.B
        io.dec.d := true.B
        io.dec.e := true.B
        io.dec.f := true.B
      }
      is ("b0001".U) {
        io.dec.b := true.B
        io.dec.c := true.B
      }
      is ("b0010".U) {
        io.dec.a := true.B
        io.dec.b := true.B
        io.dec.d := true.B
        io.dec.e := true.B
        io.dec.g := true.B
      }
      is ("b0011".U) {
        io.dec.a := true.B
        io.dec.b := true.B
        io.dec.c := true.B
        io.dec.d := true.B
        io.dec.g := true.B
      }
      is ("b0100".U) {
        io.dec.b := true.B
        io.dec.c := true.B
        io.dec.f := true.B
        io.dec.g := true.B
      }
      is ("b0101".U) {
        io.dec.a := true.B
        io.dec.c := true.B
        io.dec.d := true.B
        io.dec.f := true.B
        io.dec.g := true.B
      }
      is ("b0110".U) {
        io.dec.a := true.B
        io.dec.c := true.B
        io.dec.d := true.B
        io.dec.e := true.B
        io.dec.f := true.B
        io.dec.g := true.B
      }
      is ("b0111".U) {
        io.dec.a := true.B
        io.dec.b := true.B
        io.dec.c := true.B
      }
      is ("b1000".U) {
        io.dec.a := true.B
        io.dec.b := true.B
        io.dec.c := true.B
        io.dec.d := true.B
        io.dec.e := true.B
        io.dec.f := true.B
        io.dec.g := true.B
      }
      is ("b1001".U) {
        io.dec.a := true.B
        io.dec.b := true.B
        io.dec.c := true.B
        io.dec.d := true.B
        io.dec.f := true.B
        io.dec.g := true.B
      }
      is ("b1010".U) {
        io.dec.a := true.B
        io.dec.b := true.B
        io.dec.c := true.B
        io.dec.e := true.B
        io.dec.f := true.B
        io.dec.g := true.B
      }
      is ("b1011".U) {
        io.dec.c := true.B
        io.dec.d := true.B
        io.dec.e := true.B
        io.dec.f := true.B
        io.dec.g := true.B
      }
      is ("b1100".U) {
        io.dec.a := true.B
        io.dec.d := true.B
        io.dec.e := true.B
        io.dec.f := true.B
      }
      is ("b1101".U) {
        io.dec.b := true.B
        io.dec.c := true.B
        io.dec.d := true.B
        io.dec.e := true.B
        io.dec.g := true.B
      }
      is ("b1110".U) {
        io.dec.a := true.B
        io.dec.d := true.B
        io.dec.e := true.B
        io.dec.f := true.B
        io.dec.g := true.B
      }
      is ("b1111".U) {
        io.dec.a := true.B
        io.dec.e := true.B
        io.dec.f := true.B
        io.dec.g := true.B
      }
    }
  }
}
