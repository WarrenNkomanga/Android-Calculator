package com.example.warrencalculatorapp

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {

    lateinit var  previousCalculations:TextView
    lateinit var contentDisplay:EditText
    var backPressedTime:Long =0
    lateinit var backToast: Toast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        previousCalculations = findViewById(R.id.previousCalculationsView)
        contentDisplay = findViewById(R.id.displayEditText)
        contentDisplay.showSoftInputOnFocus = false


    }

    override fun onBackPressed() {


        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel()
            super.onBackPressed()
            return
        }
        else{
            backToast = Toast.makeText(baseContext,"Press back again to exit",Toast.LENGTH_SHORT)
            backToast.show()
        }

        backPressedTime = System.currentTimeMillis()
    }

    fun updateText(stringToAdd:String){
        val oldString: String = contentDisplay.text.toString()

        val cursorPos:Int = contentDisplay.selectionStart
        val leftString : String = oldString.substring(0,cursorPos)
        val rightString: String = oldString.substring(cursorPos)

        contentDisplay.setText(java.lang.String.format("%s%s%s",leftString,stringToAdd,rightString))
        contentDisplay.setSelection(cursorPos + stringToAdd.length)
    }

    fun zeroBtnPush (view: View) {
        updateText(getString(R.string.zero_text))
    }
    fun oneBtnPush (view: View) {
        updateText(getString(R.string.one_text))
    }
    fun twoBtnPush (view: View) {
        updateText(getString(R.string.two_text))
    }
    fun threeBtnPush (view: View) {
        updateText(getString(R.string.three_text))
    }
    fun fourBtnPush (view: View) {
        updateText(getString(R.string.four_text))
    }
    fun fiveBtnPush (view: View) {
        updateText(getString(R.string.five_text))
    }
    fun sixBtnPush (view: View) {
        updateText(getString(R.string.six_text))
    }
    fun sevenBtnPush (view: View) {
        updateText(getString(R.string.seven_text))
    }
    fun eightBtnPush (view: View) {
        updateText(getString(R.string.eight_text))
    }
    fun nineBtnPush (view: View) {
        updateText(getString(R.string.nine_text))
    }
    fun leftBracketBtnPush (view: View) {
        updateText(getString(R.string.leftBracket_text))
    }
    fun rightBracketBtnPush (view: View) {
        updateText(getString(R.string.rightBracket_text))
    }
    fun multiplicationBtnPush (view: View) {
        updateText(getString(R.string.multiplication_text))
    }
    fun subtractionBtnPush (view: View) {
        updateText(getString(R.string.subtraction_text))
    }
    fun additionBtnPush (view: View) {
        updateText(getString(R.string.addition_text))
    }
    fun decimalBtnPush (view: View) {
        updateText(getString(R.string.decimal_text))
    }
    fun divisionBtnPush (view: View) {
        updateText(getString(R.string.division_text))
    }
    fun clearBtnPush(view: View){
        contentDisplay.setText("")
        previousCalculations.text = ""
    }
    fun backSpaceBtnPush(view: View){
        val cursorPos:Int = contentDisplay.selectionStart
        val textLength:Int = contentDisplay.text.length

        if(cursorPos !=0 && textLength !=0){
            val selection:SpannableStringBuilder = contentDisplay.text as SpannableStringBuilder
            selection.replace(cursorPos - 1, cursorPos, "")
            contentDisplay.text = selection
            contentDisplay.setSelection(cursorPos - 1)
        }
    }
    fun equalsBtnPush(view: View){
        var userExpression: String = contentDisplay.text.toString()

        previousCalculations.text = userExpression

        userExpression = userExpression.replace(getString(R.string.division_text), "/")
        userExpression = userExpression.replace(getString(R.string.multiplication_text), "*")

        val exp: Expression = Expression(userExpression)
        val resultCalc: String = java.lang.String.valueOf(exp.calculate())

        contentDisplay.setText(resultCalc)
        contentDisplay.setSelection(resultCalc.length)

    }
    fun trigSinBtnPush(view: View){
        updateText("sin(")
    }
    fun trigCosBtnPush(view: View){
        updateText("cos(")
    }
    fun trigTanBtnPush(view: View){
        updateText("tan(")
    }
    fun trigArcSinBtnPush(view: View){
        updateText("arcsin(")
    }
    fun trigArcCosBtnPush(view: View){
        updateText("arccos(")
    }
    fun trigArcTanBtnPush(view: View){
        updateText("arctan(")
    }
    fun logBtnPush(view: View){
        updateText("log(")
    }
    fun naturalLogBtnPush(view: View){
        updateText("ln(")
    }
    fun eulerBtnPush(view: View){
        updateText("e")
    }
    fun primeBtnPush(view: View){
        updateText("ispr(")

    }
    fun squareRootBtnPush(view: View){
        updateText("sqrt(")
    }
    fun absoluteValueBtnPush(view: View){
        updateText("abs(")
    }
    fun xSquaredBtnPush(view: View){
        updateText("^(2)")
    }
    fun xPowerYBtnPush(view: View){
        updateText("^(")
    }
    fun piBtnPush(view: View){
        updateText("pi")
    }

}