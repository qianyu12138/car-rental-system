package cn.yd.carrentalsystem.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andKidIsNull() {
            addCriterion("kid is null");
            return (Criteria) this;
        }

        public Criteria andKidIsNotNull() {
            addCriterion("kid is not null");
            return (Criteria) this;
        }

        public Criteria andKidEqualTo(Integer value) {
            addCriterion("kid =", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotEqualTo(Integer value) {
            addCriterion("kid <>", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThan(Integer value) {
            addCriterion("kid >", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThanOrEqualTo(Integer value) {
            addCriterion("kid >=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThan(Integer value) {
            addCriterion("kid <", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThanOrEqualTo(Integer value) {
            addCriterion("kid <=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidIn(List<Integer> values) {
            addCriterion("kid in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotIn(List<Integer> values) {
            addCriterion("kid not in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidBetween(Integer value1, Integer value2) {
            addCriterion("kid between", value1, value2, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotBetween(Integer value1, Integer value2) {
            addCriterion("kid not between", value1, value2, "kid");
            return (Criteria) this;
        }

        public Criteria andImgsIsNull() {
            addCriterion("imgs is null");
            return (Criteria) this;
        }

        public Criteria andImgsIsNotNull() {
            addCriterion("imgs is not null");
            return (Criteria) this;
        }

        public Criteria andImgsEqualTo(String value) {
            addCriterion("imgs =", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotEqualTo(String value) {
            addCriterion("imgs <>", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsGreaterThan(String value) {
            addCriterion("imgs >", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsGreaterThanOrEqualTo(String value) {
            addCriterion("imgs >=", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLessThan(String value) {
            addCriterion("imgs <", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLessThanOrEqualTo(String value) {
            addCriterion("imgs <=", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLike(String value) {
            addCriterion("imgs like", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotLike(String value) {
            addCriterion("imgs not like", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsIn(List<String> values) {
            addCriterion("imgs in", values, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotIn(List<String> values) {
            addCriterion("imgs not in", values, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsBetween(String value1, String value2) {
            addCriterion("imgs between", value1, value2, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotBetween(String value1, String value2) {
            addCriterion("imgs not between", value1, value2, "imgs");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc not between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andLicensenumberIsNull() {
            addCriterion("licenseNumber is null");
            return (Criteria) this;
        }

        public Criteria andLicensenumberIsNotNull() {
            addCriterion("licenseNumber is not null");
            return (Criteria) this;
        }

        public Criteria andLicensenumberEqualTo(String value) {
            addCriterion("licenseNumber =", value, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberNotEqualTo(String value) {
            addCriterion("licenseNumber <>", value, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberGreaterThan(String value) {
            addCriterion("licenseNumber >", value, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberGreaterThanOrEqualTo(String value) {
            addCriterion("licenseNumber >=", value, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberLessThan(String value) {
            addCriterion("licenseNumber <", value, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberLessThanOrEqualTo(String value) {
            addCriterion("licenseNumber <=", value, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberLike(String value) {
            addCriterion("licenseNumber like", value, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberNotLike(String value) {
            addCriterion("licenseNumber not like", value, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberIn(List<String> values) {
            addCriterion("licenseNumber in", values, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberNotIn(List<String> values) {
            addCriterion("licenseNumber not in", values, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberBetween(String value1, String value2) {
            addCriterion("licenseNumber between", value1, value2, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andLicensenumberNotBetween(String value1, String value2) {
            addCriterion("licenseNumber not between", value1, value2, "licensenumber");
            return (Criteria) this;
        }

        public Criteria andSitnumberIsNull() {
            addCriterion("sitNumber is null");
            return (Criteria) this;
        }

        public Criteria andSitnumberIsNotNull() {
            addCriterion("sitNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSitnumberEqualTo(Integer value) {
            addCriterion("sitNumber =", value, "sitnumber");
            return (Criteria) this;
        }

        public Criteria andSitnumberNotEqualTo(Integer value) {
            addCriterion("sitNumber <>", value, "sitnumber");
            return (Criteria) this;
        }

        public Criteria andSitnumberGreaterThan(Integer value) {
            addCriterion("sitNumber >", value, "sitnumber");
            return (Criteria) this;
        }

        public Criteria andSitnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sitNumber >=", value, "sitnumber");
            return (Criteria) this;
        }

        public Criteria andSitnumberLessThan(Integer value) {
            addCriterion("sitNumber <", value, "sitnumber");
            return (Criteria) this;
        }

        public Criteria andSitnumberLessThanOrEqualTo(Integer value) {
            addCriterion("sitNumber <=", value, "sitnumber");
            return (Criteria) this;
        }

        public Criteria andSitnumberIn(List<Integer> values) {
            addCriterion("sitNumber in", values, "sitnumber");
            return (Criteria) this;
        }

        public Criteria andSitnumberNotIn(List<Integer> values) {
            addCriterion("sitNumber not in", values, "sitnumber");
            return (Criteria) this;
        }

        public Criteria andSitnumberBetween(Integer value1, Integer value2) {
            addCriterion("sitNumber between", value1, value2, "sitnumber");
            return (Criteria) this;
        }

        public Criteria andSitnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sitNumber not between", value1, value2, "sitnumber");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(Float value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(Float value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(Float value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(Float value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(Float value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(Float value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<Float> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<Float> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(Float value1, Float value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(Float value1, Float value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStartaddressIsNull() {
            addCriterion("startAddress is null");
            return (Criteria) this;
        }

        public Criteria andStartaddressIsNotNull() {
            addCriterion("startAddress is not null");
            return (Criteria) this;
        }

        public Criteria andStartaddressEqualTo(String value) {
            addCriterion("startAddress =", value, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressNotEqualTo(String value) {
            addCriterion("startAddress <>", value, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressGreaterThan(String value) {
            addCriterion("startAddress >", value, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressGreaterThanOrEqualTo(String value) {
            addCriterion("startAddress >=", value, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressLessThan(String value) {
            addCriterion("startAddress <", value, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressLessThanOrEqualTo(String value) {
            addCriterion("startAddress <=", value, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressLike(String value) {
            addCriterion("startAddress like", value, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressNotLike(String value) {
            addCriterion("startAddress not like", value, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressIn(List<String> values) {
            addCriterion("startAddress in", values, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressNotIn(List<String> values) {
            addCriterion("startAddress not in", values, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressBetween(String value1, String value2) {
            addCriterion("startAddress between", value1, value2, "startaddress");
            return (Criteria) this;
        }

        public Criteria andStartaddressNotBetween(String value1, String value2) {
            addCriterion("startAddress not between", value1, value2, "startaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressIsNull() {
            addCriterion("endAddress is null");
            return (Criteria) this;
        }

        public Criteria andEndaddressIsNotNull() {
            addCriterion("endAddress is not null");
            return (Criteria) this;
        }

        public Criteria andEndaddressEqualTo(String value) {
            addCriterion("endAddress =", value, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressNotEqualTo(String value) {
            addCriterion("endAddress <>", value, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressGreaterThan(String value) {
            addCriterion("endAddress >", value, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressGreaterThanOrEqualTo(String value) {
            addCriterion("endAddress >=", value, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressLessThan(String value) {
            addCriterion("endAddress <", value, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressLessThanOrEqualTo(String value) {
            addCriterion("endAddress <=", value, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressLike(String value) {
            addCriterion("endAddress like", value, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressNotLike(String value) {
            addCriterion("endAddress not like", value, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressIn(List<String> values) {
            addCriterion("endAddress in", values, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressNotIn(List<String> values) {
            addCriterion("endAddress not in", values, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressBetween(String value1, String value2) {
            addCriterion("endAddress between", value1, value2, "endaddress");
            return (Criteria) this;
        }

        public Criteria andEndaddressNotBetween(String value1, String value2) {
            addCriterion("endAddress not between", value1, value2, "endaddress");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}