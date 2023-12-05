package mypage.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import payment.bean.PointChargingDTO;
import user.bean.DogsInfoDTO;
import user.bean.User;
import user.bean.UserDTO;

public interface MypageService {

	public User getUserProfile(Long userId);

	public UserDTO getUserProfileTest(Long userId);
	
	public void writeUser(UserDTO userDTO); //이거 실제로 안씀.
	
	public PointChargingDTO getPointCharging(Long userId);

	public void write(DogsInfoDTO dogsInfoDTO);

	public Page<DogsInfoDTO> getDogInfoList(Pageable pageable);


}