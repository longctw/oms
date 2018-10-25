package info.ilong.oms.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andBailorIsNull() {
            addCriterion("bailor is null");
            return (Criteria) this;
        }

        public Criteria andBailorIsNotNull() {
            addCriterion("bailor is not null");
            return (Criteria) this;
        }

        public Criteria andBailorEqualTo(String value) {
            addCriterion("bailor =", value, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorNotEqualTo(String value) {
            addCriterion("bailor <>", value, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorGreaterThan(String value) {
            addCriterion("bailor >", value, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorGreaterThanOrEqualTo(String value) {
            addCriterion("bailor >=", value, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorLessThan(String value) {
            addCriterion("bailor <", value, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorLessThanOrEqualTo(String value) {
            addCriterion("bailor <=", value, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorLike(String value) {
            addCriterion("bailor like", value, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorNotLike(String value) {
            addCriterion("bailor not like", value, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorIn(List<String> values) {
            addCriterion("bailor in", values, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorNotIn(List<String> values) {
            addCriterion("bailor not in", values, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorBetween(String value1, String value2) {
            addCriterion("bailor between", value1, value2, "bailor");
            return (Criteria) this;
        }

        public Criteria andBailorNotBetween(String value1, String value2) {
            addCriterion("bailor not between", value1, value2, "bailor");
            return (Criteria) this;
        }

        public Criteria andScheduleIsNull() {
            addCriterion("schedule is null");
            return (Criteria) this;
        }

        public Criteria andScheduleIsNotNull() {
            addCriterion("schedule is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleEqualTo(String value) {
            addCriterion("schedule =", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotEqualTo(String value) {
            addCriterion("schedule <>", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleGreaterThan(String value) {
            addCriterion("schedule >", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleGreaterThanOrEqualTo(String value) {
            addCriterion("schedule >=", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLessThan(String value) {
            addCriterion("schedule <", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLessThanOrEqualTo(String value) {
            addCriterion("schedule <=", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLike(String value) {
            addCriterion("schedule like", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotLike(String value) {
            addCriterion("schedule not like", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleIn(List<String> values) {
            addCriterion("schedule in", values, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotIn(List<String> values) {
            addCriterion("schedule not in", values, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleBetween(String value1, String value2) {
            addCriterion("schedule between", value1, value2, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotBetween(String value1, String value2) {
            addCriterion("schedule not between", value1, value2, "schedule");
            return (Criteria) this;
        }

        public Criteria andSumMoneyIsNull() {
            addCriterion("sum_money is null");
            return (Criteria) this;
        }

        public Criteria andSumMoneyIsNotNull() {
            addCriterion("sum_money is not null");
            return (Criteria) this;
        }

        public Criteria andSumMoneyEqualTo(Integer value) {
            addCriterion("sum_money =", value, "sumMoney");
            return (Criteria) this;
        }

        public Criteria andSumMoneyNotEqualTo(Integer value) {
            addCriterion("sum_money <>", value, "sumMoney");
            return (Criteria) this;
        }

        public Criteria andSumMoneyGreaterThan(Integer value) {
            addCriterion("sum_money >", value, "sumMoney");
            return (Criteria) this;
        }

        public Criteria andSumMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum_money >=", value, "sumMoney");
            return (Criteria) this;
        }

        public Criteria andSumMoneyLessThan(Integer value) {
            addCriterion("sum_money <", value, "sumMoney");
            return (Criteria) this;
        }

        public Criteria andSumMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("sum_money <=", value, "sumMoney");
            return (Criteria) this;
        }

        public Criteria andSumMoneyIn(List<Integer> values) {
            addCriterion("sum_money in", values, "sumMoney");
            return (Criteria) this;
        }

        public Criteria andSumMoneyNotIn(List<Integer> values) {
            addCriterion("sum_money not in", values, "sumMoney");
            return (Criteria) this;
        }

        public Criteria andSumMoneyBetween(Integer value1, Integer value2) {
            addCriterion("sum_money between", value1, value2, "sumMoney");
            return (Criteria) this;
        }

        public Criteria andSumMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("sum_money not between", value1, value2, "sumMoney");
            return (Criteria) this;
        }

        public Criteria andRequireDateIsNull() {
            addCriterion("require_date is null");
            return (Criteria) this;
        }

        public Criteria andRequireDateIsNotNull() {
            addCriterion("require_date is not null");
            return (Criteria) this;
        }

        public Criteria andRequireDateEqualTo(Date value) {
            addCriterionForJDBCDate("require_date =", value, "requireDate");
            return (Criteria) this;
        }

        public Criteria andRequireDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("require_date <>", value, "requireDate");
            return (Criteria) this;
        }

        public Criteria andRequireDateGreaterThan(Date value) {
            addCriterionForJDBCDate("require_date >", value, "requireDate");
            return (Criteria) this;
        }

        public Criteria andRequireDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("require_date >=", value, "requireDate");
            return (Criteria) this;
        }

        public Criteria andRequireDateLessThan(Date value) {
            addCriterionForJDBCDate("require_date <", value, "requireDate");
            return (Criteria) this;
        }

        public Criteria andRequireDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("require_date <=", value, "requireDate");
            return (Criteria) this;
        }

        public Criteria andRequireDateIn(List<Date> values) {
            addCriterionForJDBCDate("require_date in", values, "requireDate");
            return (Criteria) this;
        }

        public Criteria andRequireDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("require_date not in", values, "requireDate");
            return (Criteria) this;
        }

        public Criteria andRequireDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("require_date between", value1, value2, "requireDate");
            return (Criteria) this;
        }

        public Criteria andRequireDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("require_date not between", value1, value2, "requireDate");
            return (Criteria) this;
        }

        public Criteria andCompeteDateIsNull() {
            addCriterion("compete_date is null");
            return (Criteria) this;
        }

        public Criteria andCompeteDateIsNotNull() {
            addCriterion("compete_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompeteDateEqualTo(Date value) {
            addCriterionForJDBCDate("compete_date =", value, "competeDate");
            return (Criteria) this;
        }

        public Criteria andCompeteDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("compete_date <>", value, "competeDate");
            return (Criteria) this;
        }

        public Criteria andCompeteDateGreaterThan(Date value) {
            addCriterionForJDBCDate("compete_date >", value, "competeDate");
            return (Criteria) this;
        }

        public Criteria andCompeteDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("compete_date >=", value, "competeDate");
            return (Criteria) this;
        }

        public Criteria andCompeteDateLessThan(Date value) {
            addCriterionForJDBCDate("compete_date <", value, "competeDate");
            return (Criteria) this;
        }

        public Criteria andCompeteDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("compete_date <=", value, "competeDate");
            return (Criteria) this;
        }

        public Criteria andCompeteDateIn(List<Date> values) {
            addCriterionForJDBCDate("compete_date in", values, "competeDate");
            return (Criteria) this;
        }

        public Criteria andCompeteDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("compete_date not in", values, "competeDate");
            return (Criteria) this;
        }

        public Criteria andCompeteDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("compete_date between", value1, value2, "competeDate");
            return (Criteria) this;
        }

        public Criteria andCompeteDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("compete_date not between", value1, value2, "competeDate");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andFilesIsNull() {
            addCriterion("files is null");
            return (Criteria) this;
        }

        public Criteria andFilesIsNotNull() {
            addCriterion("files is not null");
            return (Criteria) this;
        }

        public Criteria andFilesEqualTo(String value) {
            addCriterion("files =", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotEqualTo(String value) {
            addCriterion("files <>", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesGreaterThan(String value) {
            addCriterion("files >", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesGreaterThanOrEqualTo(String value) {
            addCriterion("files >=", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesLessThan(String value) {
            addCriterion("files <", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesLessThanOrEqualTo(String value) {
            addCriterion("files <=", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesLike(String value) {
            addCriterion("files like", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotLike(String value) {
            addCriterion("files not like", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesIn(List<String> values) {
            addCriterion("files in", values, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotIn(List<String> values) {
            addCriterion("files not in", values, "files");
            return (Criteria) this;
        }

        public Criteria andFilesBetween(String value1, String value2) {
            addCriterion("files between", value1, value2, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotBetween(String value1, String value2) {
            addCriterion("files not between", value1, value2, "files");
            return (Criteria) this;
        }

        public Criteria andCusNameIsNull() {
            addCriterion("cus_name is null");
            return (Criteria) this;
        }

        public Criteria andCusNameIsNotNull() {
            addCriterion("cus_name is not null");
            return (Criteria) this;
        }

        public Criteria andCusNameEqualTo(String value) {
            addCriterion("cus_name =", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotEqualTo(String value) {
            addCriterion("cus_name <>", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameGreaterThan(String value) {
            addCriterion("cus_name >", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameGreaterThanOrEqualTo(String value) {
            addCriterion("cus_name >=", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLessThan(String value) {
            addCriterion("cus_name <", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLessThanOrEqualTo(String value) {
            addCriterion("cus_name <=", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLike(String value) {
            addCriterion("cus_name like", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotLike(String value) {
            addCriterion("cus_name not like", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameIn(List<String> values) {
            addCriterion("cus_name in", values, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotIn(List<String> values) {
            addCriterion("cus_name not in", values, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameBetween(String value1, String value2) {
            addCriterion("cus_name between", value1, value2, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotBetween(String value1, String value2) {
            addCriterion("cus_name not between", value1, value2, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusCompanyIsNull() {
            addCriterion("cus_company is null");
            return (Criteria) this;
        }

        public Criteria andCusCompanyIsNotNull() {
            addCriterion("cus_company is not null");
            return (Criteria) this;
        }

        public Criteria andCusCompanyEqualTo(String value) {
            addCriterion("cus_company =", value, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyNotEqualTo(String value) {
            addCriterion("cus_company <>", value, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyGreaterThan(String value) {
            addCriterion("cus_company >", value, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("cus_company >=", value, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyLessThan(String value) {
            addCriterion("cus_company <", value, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyLessThanOrEqualTo(String value) {
            addCriterion("cus_company <=", value, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyLike(String value) {
            addCriterion("cus_company like", value, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyNotLike(String value) {
            addCriterion("cus_company not like", value, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyIn(List<String> values) {
            addCriterion("cus_company in", values, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyNotIn(List<String> values) {
            addCriterion("cus_company not in", values, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyBetween(String value1, String value2) {
            addCriterion("cus_company between", value1, value2, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusCompanyNotBetween(String value1, String value2) {
            addCriterion("cus_company not between", value1, value2, "cusCompany");
            return (Criteria) this;
        }

        public Criteria andCusAddressIsNull() {
            addCriterion("cus_address is null");
            return (Criteria) this;
        }

        public Criteria andCusAddressIsNotNull() {
            addCriterion("cus_address is not null");
            return (Criteria) this;
        }

        public Criteria andCusAddressEqualTo(String value) {
            addCriterion("cus_address =", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressNotEqualTo(String value) {
            addCriterion("cus_address <>", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressGreaterThan(String value) {
            addCriterion("cus_address >", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressGreaterThanOrEqualTo(String value) {
            addCriterion("cus_address >=", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressLessThan(String value) {
            addCriterion("cus_address <", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressLessThanOrEqualTo(String value) {
            addCriterion("cus_address <=", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressLike(String value) {
            addCriterion("cus_address like", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressNotLike(String value) {
            addCriterion("cus_address not like", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressIn(List<String> values) {
            addCriterion("cus_address in", values, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressNotIn(List<String> values) {
            addCriterion("cus_address not in", values, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressBetween(String value1, String value2) {
            addCriterion("cus_address between", value1, value2, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressNotBetween(String value1, String value2) {
            addCriterion("cus_address not between", value1, value2, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusPhoneIsNull() {
            addCriterion("cus_phone is null");
            return (Criteria) this;
        }

        public Criteria andCusPhoneIsNotNull() {
            addCriterion("cus_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCusPhoneEqualTo(String value) {
            addCriterion("cus_phone =", value, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneNotEqualTo(String value) {
            addCriterion("cus_phone <>", value, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneGreaterThan(String value) {
            addCriterion("cus_phone >", value, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cus_phone >=", value, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneLessThan(String value) {
            addCriterion("cus_phone <", value, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneLessThanOrEqualTo(String value) {
            addCriterion("cus_phone <=", value, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneLike(String value) {
            addCriterion("cus_phone like", value, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneNotLike(String value) {
            addCriterion("cus_phone not like", value, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneIn(List<String> values) {
            addCriterion("cus_phone in", values, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneNotIn(List<String> values) {
            addCriterion("cus_phone not in", values, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneBetween(String value1, String value2) {
            addCriterion("cus_phone between", value1, value2, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusPhoneNotBetween(String value1, String value2) {
            addCriterion("cus_phone not between", value1, value2, "cusPhone");
            return (Criteria) this;
        }

        public Criteria andCusDescIsNull() {
            addCriterion("cus_desc is null");
            return (Criteria) this;
        }

        public Criteria andCusDescIsNotNull() {
            addCriterion("cus_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCusDescEqualTo(String value) {
            addCriterion("cus_desc =", value, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescNotEqualTo(String value) {
            addCriterion("cus_desc <>", value, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescGreaterThan(String value) {
            addCriterion("cus_desc >", value, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescGreaterThanOrEqualTo(String value) {
            addCriterion("cus_desc >=", value, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescLessThan(String value) {
            addCriterion("cus_desc <", value, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescLessThanOrEqualTo(String value) {
            addCriterion("cus_desc <=", value, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescLike(String value) {
            addCriterion("cus_desc like", value, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescNotLike(String value) {
            addCriterion("cus_desc not like", value, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescIn(List<String> values) {
            addCriterion("cus_desc in", values, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescNotIn(List<String> values) {
            addCriterion("cus_desc not in", values, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescBetween(String value1, String value2) {
            addCriterion("cus_desc between", value1, value2, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andCusDescNotBetween(String value1, String value2) {
            addCriterion("cus_desc not between", value1, value2, "cusDesc");
            return (Criteria) this;
        }

        public Criteria andExpressInfoIsNull() {
            addCriterion("express_info is null");
            return (Criteria) this;
        }

        public Criteria andExpressInfoIsNotNull() {
            addCriterion("express_info is not null");
            return (Criteria) this;
        }

        public Criteria andExpressInfoEqualTo(String value) {
            addCriterion("express_info =", value, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoNotEqualTo(String value) {
            addCriterion("express_info <>", value, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoGreaterThan(String value) {
            addCriterion("express_info >", value, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoGreaterThanOrEqualTo(String value) {
            addCriterion("express_info >=", value, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoLessThan(String value) {
            addCriterion("express_info <", value, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoLessThanOrEqualTo(String value) {
            addCriterion("express_info <=", value, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoLike(String value) {
            addCriterion("express_info like", value, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoNotLike(String value) {
            addCriterion("express_info not like", value, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoIn(List<String> values) {
            addCriterion("express_info in", values, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoNotIn(List<String> values) {
            addCriterion("express_info not in", values, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoBetween(String value1, String value2) {
            addCriterion("express_info between", value1, value2, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressInfoNotBetween(String value1, String value2) {
            addCriterion("express_info not between", value1, value2, "expressInfo");
            return (Criteria) this;
        }

        public Criteria andExpressDateIsNull() {
            addCriterion("express_date is null");
            return (Criteria) this;
        }

        public Criteria andExpressDateIsNotNull() {
            addCriterion("express_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpressDateEqualTo(Date value) {
            addCriterionForJDBCDate("express_date =", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("express_date <>", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateGreaterThan(Date value) {
            addCriterionForJDBCDate("express_date >", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("express_date >=", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateLessThan(Date value) {
            addCriterionForJDBCDate("express_date <", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("express_date <=", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateIn(List<Date> values) {
            addCriterionForJDBCDate("express_date in", values, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("express_date not in", values, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("express_date between", value1, value2, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("express_date not between", value1, value2, "expressDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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