package com.zjl.mouse.mousedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VakaOssExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VakaOssExample() {
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

        public Criteria andFIdIsNull() {
            addCriterion("F_ID is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("F_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Long value) {
            addCriterion("F_ID =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Long value) {
            addCriterion("F_ID <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Long value) {
            addCriterion("F_ID >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Long value) {
            addCriterion("F_ID >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Long value) {
            addCriterion("F_ID <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Long value) {
            addCriterion("F_ID <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Long> values) {
            addCriterion("F_ID in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Long> values) {
            addCriterion("F_ID not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Long value1, Long value2) {
            addCriterion("F_ID between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Long value1, Long value2) {
            addCriterion("F_ID not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFNameIsNull() {
            addCriterion("F_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFNameIsNotNull() {
            addCriterion("F_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFNameEqualTo(String value) {
            addCriterion("F_NAME =", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotEqualTo(String value) {
            addCriterion("F_NAME <>", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThan(String value) {
            addCriterion("F_NAME >", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThanOrEqualTo(String value) {
            addCriterion("F_NAME >=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThan(String value) {
            addCriterion("F_NAME <", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThanOrEqualTo(String value) {
            addCriterion("F_NAME <=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLike(String value) {
            addCriterion("F_NAME like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotLike(String value) {
            addCriterion("F_NAME not like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameIn(List<String> values) {
            addCriterion("F_NAME in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotIn(List<String> values) {
            addCriterion("F_NAME not in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameBetween(String value1, String value2) {
            addCriterion("F_NAME between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotBetween(String value1, String value2) {
            addCriterion("F_NAME not between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFUrlIsNull() {
            addCriterion("F_URL is null");
            return (Criteria) this;
        }

        public Criteria andFUrlIsNotNull() {
            addCriterion("F_URL is not null");
            return (Criteria) this;
        }

        public Criteria andFUrlEqualTo(String value) {
            addCriterion("F_URL =", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlNotEqualTo(String value) {
            addCriterion("F_URL <>", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlGreaterThan(String value) {
            addCriterion("F_URL >", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlGreaterThanOrEqualTo(String value) {
            addCriterion("F_URL >=", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlLessThan(String value) {
            addCriterion("F_URL <", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlLessThanOrEqualTo(String value) {
            addCriterion("F_URL <=", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlLike(String value) {
            addCriterion("F_URL like", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlNotLike(String value) {
            addCriterion("F_URL not like", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlIn(List<String> values) {
            addCriterion("F_URL in", values, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlNotIn(List<String> values) {
            addCriterion("F_URL not in", values, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlBetween(String value1, String value2) {
            addCriterion("F_URL between", value1, value2, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlNotBetween(String value1, String value2) {
            addCriterion("F_URL not between", value1, value2, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFBucketIsNull() {
            addCriterion("F_BUCKET is null");
            return (Criteria) this;
        }

        public Criteria andFBucketIsNotNull() {
            addCriterion("F_BUCKET is not null");
            return (Criteria) this;
        }

        public Criteria andFBucketEqualTo(String value) {
            addCriterion("F_BUCKET =", value, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketNotEqualTo(String value) {
            addCriterion("F_BUCKET <>", value, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketGreaterThan(String value) {
            addCriterion("F_BUCKET >", value, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketGreaterThanOrEqualTo(String value) {
            addCriterion("F_BUCKET >=", value, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketLessThan(String value) {
            addCriterion("F_BUCKET <", value, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketLessThanOrEqualTo(String value) {
            addCriterion("F_BUCKET <=", value, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketLike(String value) {
            addCriterion("F_BUCKET like", value, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketNotLike(String value) {
            addCriterion("F_BUCKET not like", value, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketIn(List<String> values) {
            addCriterion("F_BUCKET in", values, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketNotIn(List<String> values) {
            addCriterion("F_BUCKET not in", values, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketBetween(String value1, String value2) {
            addCriterion("F_BUCKET between", value1, value2, "fBucket");
            return (Criteria) this;
        }

        public Criteria andFBucketNotBetween(String value1, String value2) {
            addCriterion("F_BUCKET not between", value1, value2, "fBucket");
            return (Criteria) this;
        }

        public Criteria andIsFolderIsNull() {
            addCriterion("IS_FOLDER is null");
            return (Criteria) this;
        }

        public Criteria andIsFolderIsNotNull() {
            addCriterion("IS_FOLDER is not null");
            return (Criteria) this;
        }

        public Criteria andIsFolderEqualTo(String value) {
            addCriterion("IS_FOLDER =", value, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderNotEqualTo(String value) {
            addCriterion("IS_FOLDER <>", value, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderGreaterThan(String value) {
            addCriterion("IS_FOLDER >", value, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderGreaterThanOrEqualTo(String value) {
            addCriterion("IS_FOLDER >=", value, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderLessThan(String value) {
            addCriterion("IS_FOLDER <", value, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderLessThanOrEqualTo(String value) {
            addCriterion("IS_FOLDER <=", value, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderLike(String value) {
            addCriterion("IS_FOLDER like", value, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderNotLike(String value) {
            addCriterion("IS_FOLDER not like", value, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderIn(List<String> values) {
            addCriterion("IS_FOLDER in", values, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderNotIn(List<String> values) {
            addCriterion("IS_FOLDER not in", values, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderBetween(String value1, String value2) {
            addCriterion("IS_FOLDER between", value1, value2, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsFolderNotBetween(String value1, String value2) {
            addCriterion("IS_FOLDER not between", value1, value2, "isFolder");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("IS_DELETE is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("IS_DELETE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("IS_DELETE =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("IS_DELETE <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("IS_DELETE >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DELETE >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("IS_DELETE <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("IS_DELETE <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("IS_DELETE like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("IS_DELETE not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("IS_DELETE in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("IS_DELETE not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("IS_DELETE between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("IS_DELETE not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andServerPathIsNull() {
            addCriterion("SERVER_PATH is null");
            return (Criteria) this;
        }

        public Criteria andServerPathIsNotNull() {
            addCriterion("SERVER_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andServerPathEqualTo(String value) {
            addCriterion("SERVER_PATH =", value, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathNotEqualTo(String value) {
            addCriterion("SERVER_PATH <>", value, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathGreaterThan(String value) {
            addCriterion("SERVER_PATH >", value, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathGreaterThanOrEqualTo(String value) {
            addCriterion("SERVER_PATH >=", value, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathLessThan(String value) {
            addCriterion("SERVER_PATH <", value, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathLessThanOrEqualTo(String value) {
            addCriterion("SERVER_PATH <=", value, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathLike(String value) {
            addCriterion("SERVER_PATH like", value, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathNotLike(String value) {
            addCriterion("SERVER_PATH not like", value, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathIn(List<String> values) {
            addCriterion("SERVER_PATH in", values, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathNotIn(List<String> values) {
            addCriterion("SERVER_PATH not in", values, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathBetween(String value1, String value2) {
            addCriterion("SERVER_PATH between", value1, value2, "serverPath");
            return (Criteria) this;
        }

        public Criteria andServerPathNotBetween(String value1, String value2) {
            addCriterion("SERVER_PATH not between", value1, value2, "serverPath");
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