package com.cpl.tsl.bean;

import java.util.Date;

public class ChinaDate {

    /**

     * 公历时间

     */

    private Date solarDate;

    /**

     * 农历日

     */

    private String lunar;

    /**

     * 公历日

     */

    private String solar;

    /**

     * 是否是 休

     */

    private boolean isVacation = false;

    /**

     * 如果是 休情况下的假期名字

     */

    private String VacationName = "非假期";

    /**

     * 是否是 班

     */

    private boolean isWorkFlag = false;

    private boolean isSaturday = false;

    private boolean isSunday = false;

    /**

     * @return the solarDate

     */

    public Date getSolarDate() {

        return solarDate;

    }

    /**

     * @param solarDate the solarDate to set

     */

    public void setSolarDate(Date solarDate) {

        this.solarDate = solarDate;

    }

    /**

     * @return the lunar

     */

    public String getLunar() {

        return lunar;

    }

    /**

     * @param lunar the lunar to set

     */

    public void setLunar(String lunar) {

        this.lunar = lunar;

    }

    /**

     * @return the solar

     */

    public String getSolar() {

        return solar;

    }

    /**

     * @param solar the solar to set

     */

    public void setSolar(String solar) {

        this.solar = solar;

    }

    /**

     * @return the isVacation

     */

    public boolean isVacation() {

        return isVacation;

    }

    /**

     * @param isVacation the isVacation to set

     */

    public void setVacation(boolean isVacation) {

        this.isVacation = isVacation;

    }

    /**

     * @return the vacationName

     */

    public String getVacationName() {

        return VacationName;

    }

    /**

     * @param vacationName the vacationName to set

     */

    public void setVacationName(String vacationName) {

        VacationName = vacationName;

    }

    /**

     * @return the isWorkFlag

     */

    public boolean isWorkFlag() {

        return isWorkFlag;

    }

    /**

     * @param isWorkFlag the isWorkFlag to set

     */

    public void setWorkFlag(boolean isWorkFlag) {

        this.isWorkFlag = isWorkFlag;

    }

    /**

     * @return the isSaturday

     */

    public boolean isSaturday() {

        return isSaturday;

    }

    /**

     * @param isSaturday the isSaturday to set

     */

    public void setSaturday(boolean isSaturday) {

        this.isSaturday = isSaturday;

    }

    /**

     * @return the isSunday

     */

    public boolean isSunday() {

        return isSunday;

    }

    /**

     * @param isSunday the isSunday to set

     */

    public void setSunday(boolean isSunday) {

        this.isSunday = isSunday;

    }

}
