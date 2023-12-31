import React from "react";
import { Link } from "react-router-dom";
import LeftSide from "../LeftSide";
import AdminHeader from "../AdminHeader";

const ReviewListForm = ({ openLeftside }) => {
  return (
    <>
      <AdminHeader></AdminHeader>
      <div className="leftRightContainer ">
        <LeftSide
          openLeftside={openLeftside}
          selected="문의/리뷰 관리"
        ></LeftSide>
        <div className="rightContent">여기는 리뷰관리</div>
      </div>
    </>
  );
};

export default ReviewListForm;
